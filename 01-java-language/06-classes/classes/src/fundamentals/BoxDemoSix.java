package fundamentals;

class BoxSix {
    double width;
    double height;
    double depth;

    // This is the constructor for Box.
    BoxSix() {
        System.out.println("Constructing Box");
        width = 10;
        height = 10;
        depth = 10;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}

public class BoxDemoSix {
    public static void main(String[] args) {
        // declare, allocate, and initialize Box objects
        BoxSix mybox1 = new BoxSix();
        BoxSix mybox2 = new BoxSix();

        double vol;

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
    }
}
