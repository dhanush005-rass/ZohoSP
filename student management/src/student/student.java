package student;

class student {

    // Fields to store student info and marks
    private int id;
    private String name;
    private float maths;
    private float sci;
    private float eng;
    private float avg;

    // Constructor to initialize student data and calculate average
    public student(int id, String name, float maths, float sci, float eng) {
        this.id = id;
        this.name = name;
        this.maths = maths;
        this.sci = sci;
        this.eng = eng;
        this.avg = (maths + sci + eng) / 3; // Corrected average calculation
    }

    // Returns average marks
    public float returnavg() {
        return avg;
    }

    // Returns formatted student details
    public String toString() {
        return "Student ID: " + id +
               "\nStudent Name: " + name +
               "\nMaths: " + maths +
               "\nScience: " + sci +
               "\nEnglish: " + eng +
               "\nAverage: " + avg;
    }
}
