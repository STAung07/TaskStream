package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        System.out.println("Printing deadlines");
        //printDeadlines(tasksData);
        printDeadlinesUsingStream(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlinesUsingStream(tasksData));
        //printData(tasksData);
        printDataWithStreams(tasksData);

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStream(ArrayList<Task> tasks) {
        int count = (int) tasks.stream()
                .filter((t) -> t instanceof Deadline) // filtering using lambda
                .count(); // count all those filtered out from filter
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        System.out.println("printing data by looping");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataWithStreams(ArrayList<Task> tasks) {
        System.out.println("printing data using stream");
        tasks.stream() // convert data to stream
                .forEach(System.out::println); // System.out is class name, println is method we are invoking
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesUsingStream(ArrayList<Task> tasks) {
        System.out.println("printing deadline using stream");
        tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }
}
