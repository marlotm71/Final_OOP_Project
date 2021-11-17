package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * Class Command Process
 */
public class Command_process {

    /**
     * Processing of the user command
     * @param command User command
     * @param listShapeAll List of all the shapes created since the beginning
     * @param listGroup List of all the different groups created since the beginning
     * @param nbSCreate Number of shape created since the beginning
     */
    public Command_process(String command, List<Shape> listShapeAll, List<Group> listGroup, Nbshapecreate nbSCreate){
        // Create a test
        String type_Figure_Geo = "";
        StringTokenizer st = new StringTokenizer(command, " ");
        String type_Figure_geo = st.nextToken();
        String name_Figure_geo = "";
        System.out.println(type_Figure_Geo);
        int nbSCreatebis = 0;

        switch (type_Figure_geo) {
            case ("rectangle"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo,listShapeAll,listGroup);
                double x = Integer.parseInt(st.nextToken());
                CheckPositive(x);
                double y = Integer.parseInt(st.nextToken());
                CheckPositive(y);
                double w = Integer.parseInt(st.nextToken());
                CheckPositive(w);
                double h = Integer.parseInt(st.nextToken());
                CheckPositive(h);
                nbSCreate.setNbshapecreate(nbSCreate.getNbshapecreate()+1);
                nbSCreatebis = nbSCreate.getNbshapecreate();
                Rectangle rect = new Rectangle(name_Figure_geo, nbSCreatebis, x, y,w,h);
                listShapeAll.add(rect);
                break;
            case ("circle"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo,listShapeAll,listGroup);
                x = Integer.parseInt(st.nextToken());
                CheckPositive(x);
                y = Integer.parseInt(st.nextToken());
                CheckPositive(y);
                double r = Integer.parseInt(st.nextToken());
                CheckPositive(r);
                nbSCreate.setNbshapecreate(nbSCreate.getNbshapecreate()+1);
                nbSCreatebis = nbSCreate.getNbshapecreate();
                Circle cir = new Circle(name_Figure_geo, nbSCreatebis, x, y, r);
                listShapeAll.add(cir);
                break;
            case ("line"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo,listShapeAll,listGroup);
                x = Integer.parseInt(st.nextToken());
                CheckPositive(x);
                y = Integer.parseInt(st.nextToken());
                CheckPositive(y);
                double x2 = Integer.parseInt(st.nextToken());
                CheckPositive(x2);
                double y2 = Integer.parseInt(st.nextToken());
                CheckPositive(y2);
                nbSCreate.setNbshapecreate(nbSCreate.getNbshapecreate()+1);
                nbSCreatebis = nbSCreate.getNbshapecreate();
                Line li = new Line(name_Figure_geo, nbSCreatebis, x, y, x2, y2);
                listShapeAll.add(li);
                break;
            case ("square"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo,listShapeAll,listGroup);
                x = Integer.parseInt(st.nextToken());
                CheckPositive(x);
                y = Integer.parseInt(st.nextToken());
                CheckPositive(y);
                double l = Integer.parseInt(st.nextToken());
                nbSCreate.setNbshapecreate(nbSCreate.getNbshapecreate()+1);
                nbSCreatebis = nbSCreate.getNbshapecreate();
                Square sq = new Square(name_Figure_geo, nbSCreatebis, x, y, l);
                listShapeAll.add(sq);
                break;
            case ("group"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo,listShapeAll,listGroup);
                int nbShape = st.countTokens();
                Shape[] listShapeGroup = new Shape[nbShape];
                for (int i = 0; i < nbShape; i++) {
                    String nameShapeInt = st.nextToken();
                    for (Shape elmtShapeAll : listShapeAll) {
                        if (elmtShapeAll.getName().equals(nameShapeInt)) {
                            listShapeGroup[i] = elmtShapeAll;
                        }
                    }
                }
                for (int i = 0; i < nbShape; i++) {
                    listShapeAll.remove(listShapeGroup[i]);
                }
                nbSCreate.setNbshapecreate(nbSCreate.getNbshapecreate()+1);
                nbSCreatebis = nbSCreate.getNbshapecreate();
                Group gr = new Group(name_Figure_geo, nbSCreatebis, nbShape, listShapeGroup);
                listShapeAll.add(gr);
                listGroup.add(gr);
                nbSCreatebis = nbSCreatebis - nbShape + 1;
                nbSCreate.setNbshapecreate(nbSCreatebis);
                break;
            case ("ungroup"):
                name_Figure_geo = st.nextToken();
                for (Group group : listGroup) {
                    if (group.getName().equals(name_Figure_geo)) {
                        listShapeAll.remove(group);
                        listGroup.remove(group);
                        int nbshape = group.getSize();
                        for (int i = 0; i < nbshape; i++) {
                            listShapeAll.add(group.getListShape()[i]);
                        }
                    }break;}
                break;
            case ("delete"):
                name_Figure_geo = st.nextToken();
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)) {
                        listShapeAll.remove(elmtShapeAll);
                        break;
                    }}
                break;

            case ("list"):
                name_Figure_geo = st.nextToken();
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)) {
                        elmtShapeAll.listFigure();
                    }
                    break;
                }
                break;

            case ("listAll"):
                for (Shape elmtShapeAll : listShapeAll) {
                    System.out.print("•");
                    elmtShapeAll.listFigure();
                }
                break;

            case ("quit"):
                System.out.println("Thanks, for your participation to Clevis");
                System.exit(0);
                break;
            case ("move"):
                name_Figure_geo = st.nextToken();
                double dx = Float.parseFloat(st.nextToken());
                double dy = Float.parseFloat(st.nextToken());
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)) {
                        elmtShapeAll.move(dx, dy);
                        break;}}
                break;
            case ("boundingbox"):
                name_Figure_geo = st.nextToken();
                double boundingboxX = 0;
                double boundingboxY = 0;
                double boundingboxW = 0;
                double boundingboxH = 0;
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)) {
                        if (elmtShapeAll.min_coordinate_x()<0){
                            boundingboxX = 0;}
                        else if (elmtShapeAll.min_coordinate_x()>=0){
                            boundingboxX= elmtShapeAll.min_coordinate_x();}
                        if (elmtShapeAll.min_coordinate_y()<0){
                            boundingboxY = 0;}
                        else if (elmtShapeAll.min_coordinate_y()>=0){
                            boundingboxY= elmtShapeAll.min_coordinate_y();}
                        boundingboxW = elmtShapeAll.max_coordinate_x()-boundingboxX;
                        boundingboxH = elmtShapeAll.max_coordinate_y()-boundingboxY;}
                }
                System.out.println("Boundingbox : " + boundingboxX + " " + boundingboxY + " " + boundingboxW + " " + boundingboxH);
                break;
            case ("pick-and-move"):
                double pmX = Float.parseFloat(st.nextToken());
                double pmY = Float.parseFloat(st.nextToken());
                double pmDx = Float.parseFloat(st.nextToken());
                double pmDy = Float.parseFloat(st.nextToken());
                Shape shapeToMove = null;
                int maxzOrder = 0;
                List<Shape> listShapePM = new ArrayList<>();
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.distancePoint(pmX, pmY)) {
                        listShapePM.add(elmtShapeAll);}
                }
                if (listShapePM.isEmpty()) {
                    throw new Clevis.Pick_and_move_Error();}
                else {
                    for (Shape elmtShapePM : listShapePM) {
                        if (elmtShapePM.getzOrder() >= maxzOrder) {
                            shapeToMove = elmtShapePM;
                            maxzOrder = elmtShapePM.getzOrder();}
                    }
                    for (Shape elmtShapeAll : listShapeAll) {
                        if ((elmtShapeAll.getName()).equals(shapeToMove.getName())) {
                            elmtShapeAll.move(pmDx, pmDy);}
                    }}
                break;
            case ("intersect"):
                name_Figure_geo = st.nextToken();
                String name_Figure_geo2 = "";
                name_Figure_geo2 = st.nextToken();
                Shape shape1 = null;
                Shape shape2 = null;
                boolean intersect = false;//find both shapes in listShapeAll
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)) shape1 = elmtShapeAll;
                    if (elmtShapeAll.getName().equals(name_Figure_geo2)) {
                        shape2 = elmtShapeAll;}
                }
                if (shape1 == null || shape2 == null) throw new Clevis.Fig_not_recognized();
                else intersect = generalIntersect(shape1, shape2, listShapeAll);
                if (intersect == true) System.out.println("The two shapes intersect with each other");
                else {
                    System.out.println("The two shapes don't intersect with each other");
                }
                break;

            default:
                throw new Clevis.Fig_not_recognized();
                //Create an error corresponding to * in case of a user command error
        }}

    /**
     * Take 2 shapes, and return true if the two shapes intersect each other, false else
     * @param shape1 First Shape
     * @param shape2 Second Shape
     * @param listShapeAll List of all the shapes created since the beginning
     * @return Boolean
     */
    public boolean generalIntersect(Shape shape1, Shape shape2, List<Shape> listShapeAll){
        boolean intersect=false;
        String classElmt1 = shape1.getClass().getName();
        String classElmt2 = shape2.getClass().getName();
        switch (classElmt1) {
            case("hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                switch (classElmt2){
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                        intersect=((Line)shape1).intersect((Rectangle) shape2);
                        break;
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                        intersect=((Line)shape1).intersect((Circle) shape2);
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Square"):
                        intersect=((Line)shape1).intersect((Square) shape2);
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                        intersect=((Line)shape1).intersect((Line) shape2);
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Group"):
                        intersect=((Line)shape1).intersect((Group) shape2);
                        break;
                }
                break;
            case ("hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                Line line1=((Rectangle) shape1).transformRecInLine1();//create four lines from the rectangle
                Line line2=((Rectangle) shape1).transformRecInLine2();
                Line line3=((Rectangle) shape1).transformRecInLine3();
                Line line4=((Rectangle) shape1).transformRecInLine4();
                switch (classElmt2){
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                        if (line1.intersect((Rectangle) shape2)||line2.intersect((Rectangle) shape2)|| line3.intersect((Rectangle) shape2)||line4.intersect((Rectangle) shape2) ){
                            intersect=true;
                        }
                        break;
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                        if (line1.intersect((Circle) shape2)||line2.intersect((Circle) shape2)|| line3.intersect((Circle) shape2)||line4.intersect((Circle) shape2) ){
                            intersect=true;
                        }
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Square"):
                        if (line1.intersect((Square) shape2)||line2.intersect((Square) shape2)|| line3.intersect((Square) shape2)||line4.intersect((Square) shape2) ){
                            intersect=true;
                        }
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                        if (line1.intersect((Line) shape2)||line2.intersect((Line) shape2)|| line3.intersect((Line) shape2)||line4.intersect((Line) shape2) ){
                            intersect=true;
                        }
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Group"):
                        if (line1.intersect((Group) shape2)||line2.intersect((Group) shape2)|| line3.intersect((Group) shape2)||line4.intersect((Group) shape2) ){
                            intersect=true;
                        }
                        break;
                }
                break;
            case ("hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                switch (classElmt2){
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                        Line line100=((Rectangle) shape2).transformRecInLine1();
                        Line line200=((Rectangle) shape2).transformRecInLine2();
                        Line line300=((Rectangle) shape2).transformRecInLine3();
                        Line line400=((Rectangle) shape2).transformRecInLine4();
                        if (line100.intersect((Circle) shape1)||line200.intersect((Circle) shape1)|| line300.intersect((Circle) shape1)||line400.intersect((Circle) shape1) ){
                            intersect=true;
                        }
                        break;
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                        intersect=((Circle)shape1).intersect((Circle) shape2);
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Square"):
                        Line line1000=((Square) shape2).transformSquareInLine1();//create four lines from the square
                        Line line2000=((Square) shape2).transformSquareInLine2();
                        Line line3000=((Square) shape2).transformSquareInLine3();
                        Line line4000=((Square) shape2).transformSquareInLine4();
                        if (line1000.intersect((Circle) shape1)||line2000.intersect((Circle) shape1)|| line3000.intersect((Circle) shape1)||line4000.intersect((Circle) shape1)){
                            intersect=true;
                        }
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                        intersect=((Line)shape2).intersect((Circle) shape1);
                        break;

                    case("hk.edu.polyu.comp.comp2021.clevis.model.Group"):
                        for (Shape shape: ((Group) shape2).getListShape()){
                            if(generalIntersect(shape,shape1,listShapeAll )){
                                intersect=true;}
                        }
                        break;
                }break;
            case("hk.edu.polyu.comp.comp2021.clevis.model.Square"):
                Line line10=((Square) shape1).transformSquareInLine1();
                Line line20=((Square) shape1).transformSquareInLine2();
                Line line30=((Square) shape1).transformSquareInLine3();
                Line line40=((Square) shape1).transformSquareInLine4();
                switch (classElmt2){
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                        if (line10.intersect((Rectangle) shape2)||line20.intersect((Rectangle) shape2)|| line30.intersect((Rectangle) shape2)||line40.intersect((Rectangle) shape2) ){
                            intersect=true;}
                        break;
                    case ("hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                        if (line10.intersect((Circle) shape2)||line20.intersect((Circle) shape2)|| line30.intersect((Circle) shape2)||line40.intersect((Circle) shape2) ){
                            intersect=true;
                        }
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Square"):
                        if (line10.intersect((Square) shape2)||line20.intersect((Square) shape2)|| line30.intersect((Square) shape2)||line40.intersect((Square) shape2) ){
                            intersect=true;}
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                        if (line10.intersect((Line) shape2)||line20.intersect((Line) shape2)|| line30.intersect((Line) shape2)||line40.intersect((Line) shape2) ){
                            intersect=true;}
                        break;
                    case("hk.edu.polyu.comp.comp2021.clevis.model.Group"):
                        if (line10.intersect((Group) shape2)||line20.intersect((Group) shape2)|| line30.intersect((Group) shape2)||line40.intersect((Group) shape2) ){
                            intersect=true;}
                        break;
                }
                break;
            case("hk.edu.polyu.comp.comp2021.clevis.model.Group"):
                for (Shape shape: ((Group) shape1).getListShape()){
                    if(generalIntersect(shape,shape2,listShapeAll )){
                        intersect=true;}
                }
                break;
        }
        return intersect;
    }

    /**
     * Check if the name given in parameter is available
     * @param name_Figure_Geo Name of the geometrical figure
     * @param listShapeAll List of all the shapes created since the beginning
     * @param listGroup List of all the groups created since the beginning
     */
    public void CheckNameAvailability(String name_Figure_Geo,List<Shape> listShapeAll,List<Group> listGroup){
        for (Shape shape : listShapeAll) {
            if (shape.getName().equals(name_Figure_Geo)) {
                throw new Clevis.Name_already_used();
            }}
        for (Group group : listGroup) {
            for (Shape shape: group.getListShape()){
                if (shape.getName().equals(name_Figure_Geo)) {
                    throw new Clevis.Name_already_used();
                }}}}

    /**
     * Check if the coordinate or parameter given is positive
     * @param i coordinate or parameter
     */
    public void CheckPositive(double i){
        if (i<0 ){
            throw new Clevis.FigureNotInGridError();}
    }
}
