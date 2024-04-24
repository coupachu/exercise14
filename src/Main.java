import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import javax.swing.text.FlowView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static java.lang.Character.getType;

public class Main {
    public static void main(String[] args) {
        System.out.println("JSON with Gson example");
        serializeSimple();
        deserializeSimple();


    }

    static void serializeSimple(){
        Todos losdias = new Todos("walk the dog", false, 0, 3, "dog");
        Todos lasmamas = new Todos("pay the bills", false, 1, 4, "bills");
        ArrayList<Todos> todosList = new ArrayList<>();
        todosList.add(losdias);
        todosList.add(lasmamas);
        Gson myGson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")){
            myGson.toJson(todosList,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserializeSimple(){
        try (FileReader reader = new FileReader("data.json")){
            JsonParser parker = new JsonParser();
            JsonElement jsonElement = parker.parse(reader);
            Gson myGson = new Gson();

            Type type = new TypeToken<ArrayList<Todos>>(){}.getType();
            ArrayList<Todos> losdias = myGson.fromJson(jsonElement,type);
            System.out.println(losdias);
            String it = losdias.get(0).getBody();
            System.out.println(it);
            losdias.get(0).setBody("walk the fish");

           // System.out.println(losdias.get(0).getBody());

            System.out.println(losdias);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class Todos{
    private String body;
    private boolean isDone;
    private int id;
    private int priority;
    private String title;

    public Todos(String body, boolean isDone, int id, int priority, String title) {
        this.body = body;
        this.isDone = isDone;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "body='" + body + '\'' +
                ", isDone=" + isDone +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}
class Simple{
    private String name;
    private String email;
    private int age;
    private boolean isDev;

    public Simple(String name, String email, int age, boolean isDev) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDev = isDev;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDev=" + isDev +
                '}';
    }
}