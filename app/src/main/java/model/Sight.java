package model;

import com.yandex.mapkit.geometry.Point;

public class Sight {

    Point point;
    String name;
    String description;
    String dates;

    String imageName;

    public Sight(Point p, String n, String desc, String  imageName)
    {
        point = p;
        name = n;
        description = desc;
        dates = "";
        this.imageName = imageName;
    }
    public Sight(Point p, String n, String desc,String imageName, String dates)
    {
        this(p,n,desc, imageName);
        this.dates = dates;
    }

    public Point getPoint() {
        return point;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getDates() {
        return dates;
    }

    public String getImageName() {
        return imageName;
    }
}
