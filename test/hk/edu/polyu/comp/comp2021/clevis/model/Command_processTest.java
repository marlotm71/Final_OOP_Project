package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Command_processTest {
    String commandRect = "rectangle rec 4 9 4 3";
    String commandCir = "circle cir 5 4 2";
    String commandLine = "line lin 4 8 9 4";
    String commandSquare = "square squ 2 3 3";
    String commandGroup = "group n rec cir";
    String commandUngroup = "ungroup n";
    String commandPick_and_move = "pick-and-move 3 4 5 5";
    String commandMove = "move lin 4 4";
    String commandDelete = "delete squ";
    String commandBoundingbox = "boundingbox cir";
    String commandIntersect = "intersect squ cir";
    String commandList = "list rect";
    String commandListAll = "listAll";
    private Line vincent = new Line("lin",3, 4.0f, 8f, 9f, 4f);
    private Circle circle = new Circle("cir", 2, 5, 4, 2);
    private Circle circle2 = new Circle("cir2", 5, 3, 3, 3);
    private Square squa = new Square("squ", 4,2, 3, 3);
    private Rectangle rectangle = new Rectangle("rec", 1,4, 9, 4, 3);

    private List<Shape> listShapeAll = new ArrayList<>();
    private List<Group> listGroup = new ArrayList<>();
    private Shape[] listShapeGroup = new Shape[]{rectangle,circle};
    private Group groupy = new Group("n",2,2,listShapeGroup);
    private Nbshapecreate nbShapeCreate = new Nbshapecreate();

    @Test
    public void command_Process(){
        Command_process command = new Command_process(commandRect,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [rec]
        Rectangle rect = (Rectangle) listShapeAll.get(0);
        assertEquals(rectangle.getX(),rect.getX());
        assertEquals(rectangle.getY(),rect.getY());
        assertEquals(rectangle.getH(),rect.getH());
        assertEquals(rectangle.getW(),rect.getW());
        assertEquals(rectangle.getName(),rect.getName());
        Command_process command2 = new Command_process(commandCir,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [rec, cir]
        Circle cir = (Circle) listShapeAll.get(1);
        assertEquals(circle.getX(), cir.getX());
        assertEquals(circle.getY(), cir.getY());
        assertEquals(circle.getR(), cir.getR());
        assertEquals(circle.getName(), cir.getName());
        Command_process command3 = new Command_process(commandLine,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [rec, cir, lin]
        Line line = (Line) listShapeAll.get(2);
        assertEquals(vincent.getX(), line.getX());
        assertEquals(vincent.getY(), line.getY());
        assertEquals(vincent.getX2(), line.getX2());
        assertEquals(vincent.getY2(), line.getY2());
        assertEquals(vincent.getName(), line.getName());
        Command_process command4 = new Command_process(commandSquare,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [rec, cir, lin, squ]
        Square square = (Square) listShapeAll.get(3);
        assertEquals(squa.getX(), square.getX());
        assertEquals(squa.getY(), square.getY());
        assertEquals(squa.getL(), square.getL());
        assertEquals(squa.getName(), square.getName());
        Command_process command5 = new Command_process(commandGroup,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [lin, squ, n]
        Group group = (Group) listShapeAll.get(2); // Second Position because we've removed the rectangle and the circle of ListShapeAll
        Rectangle recgroupinit = (Rectangle) groupy.getListShape()[0];
        Rectangle recgroupfin = (Rectangle) group.getListShape()[0];
        assertEquals(recgroupinit.getX(), recgroupfin.getX());
        assertEquals(recgroupinit.getY(), recgroupfin.getY());
        assertEquals(recgroupinit.getH(), recgroupfin.getH());
        assertEquals(recgroupinit.getW(), recgroupfin.getW());
        assertEquals(recgroupinit.getName(), recgroupfin.getName());
        Command_process command6 = new Command_process(commandUngroup,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [lin, squ, rect, cir]
        Square squareafteragroup = (Square) listShapeAll.get(1);
        assertEquals(squa.getX(), squareafteragroup.getX());
        assertEquals(squa.getY(), squareafteragroup.getY());
        assertEquals(squa.getL(), squareafteragroup.getL());
        assertEquals(squa.getName(), squareafteragroup.getName());
        Line lineafteragroup = (Line) listShapeAll.get(0);
        assertEquals(vincent.getX(), lineafteragroup.getX());
        assertEquals(vincent.getY(), lineafteragroup.getY());
        assertEquals(vincent.getX2(), lineafteragroup.getX2());
        assertEquals(vincent.getY2(), lineafteragroup.getY2());
        assertEquals(vincent.getName(), lineafteragroup.getName());
        Rectangle rectafteragroup = (Rectangle) listShapeAll.get(2);
        assertEquals(rectangle.getX(), rectafteragroup.getX());
        assertEquals(rectangle.getY(), rectafteragroup.getY());
        assertEquals(rectangle.getH(), rectafteragroup.getH());
        assertEquals(rectangle.getW(), rectafteragroup.getW());
        assertEquals(rectangle.getName(), rectafteragroup.getName());
        Command_process command7 = new Command_process(commandPick_and_move,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [lin, squ(moved), rect, cir]
        Square squareaftermove = (Square) listShapeAll.get(1);
        final double dx = 5;
        final double dy = 5;
        assertEquals(squa.getX() + dx, squareaftermove.getX());
        assertEquals(squa.getY()+ dy , squareaftermove.getY());
        Command_process command8 = new Command_process(commandMove,listShapeAll,listGroup,nbShapeCreate);
        // ListShapeAll = [lin(moved), squ(moved), rect, cir]
        Line lineaftermove = (Line) listShapeAll.get(0);
        final double movedx = 4;
        final double movedy = 4;
        assertEquals(vincent.getX()+movedx, lineaftermove.getX());
        assertEquals(vincent.getY()+movedy, lineaftermove.getY());
        assertEquals(vincent.getX2()+movedx, lineaftermove.getX2());
        assertEquals(vincent.getY2()+movedy, lineaftermove.getY2());
        Command_process command9 = new Command_process(commandDelete,listShapeAll,listGroup,nbShapeCreate);
        // We delete the square which was in second poisition in listShapeAll
        // Thus, the second is now the rectangle
        Rectangle rectangleAfterDelete = (Rectangle) listShapeAll.get(1);
        assertEquals(rectangle.getName(), rectangleAfterDelete.getName());

    }

    @Test
    void generalIntersect() {
    }

    @Test
    void checkNameAvailability() {
    }

    @Test
    void checkPositive() {
    }
}