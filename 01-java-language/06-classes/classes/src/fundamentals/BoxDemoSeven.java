package fundamentals;

class BoxSeven {
    double width;
    double height;
    double depth;

    // This is the constructor for Box.
    BoxSeven(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}

public class BoxDemoSeven {
    public static void main(String[] args) {
        BoxSeven mybox1 = new BoxSeven(10, 20, 15);
        BoxSeven mybox2 = new BoxSeven(3, 6, 9);

        double vol;

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
    }
}
