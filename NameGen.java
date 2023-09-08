import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameGen {

    public ArrayList<String> save;
    protected ArrayList<String> prefix;
    protected ArrayList<String> suffix;
    protected ArrayList<String> phrase;
    protected ArrayList<String> noun1;
    protected ArrayList<String> noun2;
    protected ArrayList<String> noun3;
    protected ArrayList<String> first;
    protected ArrayList<String> second;
    protected ArrayList<String> misc;


    public NameGen() throws FileNotFoundException {
        save = new ArrayList<String>();
        prefix = new ArrayList<String>();
        suffix = new ArrayList<String>();
        phrase = new ArrayList<String>();
        noun1 = new ArrayList<String>();
        noun2 = new ArrayList<String>();
        noun3 = new ArrayList<String>();
        first = new ArrayList<String>();
        second = new ArrayList<String>();
        misc = new ArrayList<String>();

        File list = new File("prefix.txt");
        Scanner s1 = new Scanner(list);
        while (s1.hasNext()){
            prefix.add(s1.next());
        }
        list = new File("suffix.txt");
        Scanner s2 = new Scanner(list);
        while (s2.hasNext()){
            suffix.add(s2.next());
        }

        list = new File("tribephrase.txt");
        Scanner s3 = new Scanner(list);
        while (s3.hasNextLine()){
            phrase.add(s3.nextLine());
        }

        list = new File("first.txt");
        Scanner s4 = new Scanner(list);
        while (s4.hasNext()){
            first.add(s4.next());
        }

        list = new File("second.txt");
        Scanner s5 = new Scanner(list);
        while (s5.hasNext()){
            second.add(s5.next());
        }
        list = new File("other.txt");
        Scanner s6 = new Scanner(list);
        while (s6.hasNext()){
            misc.add(s6.next());
        }

        list = new File("noun1.txt");
        Scanner s7 = new Scanner(list);
        while (s7.hasNext()){
            noun1.add(s7.next());
        }

        list = new File("noun2.txt");
        Scanner s8 = new Scanner(list);
        while (s8.hasNext()){
            noun2.add(s8.next());
        }

        list = new File("noun3.txt");
        Scanner s9 = new Scanner(list);
        while (s9.hasNext()){
            noun3.add(s9.next());
        }

        s1.close();
        s2.close();
        s3.close();
        s4.close();
        s5.close();
        s6.close();
        s7.close();
        s8.close();
        s9.close();
    }

    public void saveName(String name){
        save.add(name);
    }

    public ArrayList<String> getSave(){
        return save;
    }

    public String clanGen(){
        Random rand = new Random();
        String name = "";
        String temp = "";
        int rangen = rand.nextInt(prefix.size());
        name = name + prefix.get(rangen);
        rangen = rand.nextInt(suffix.size());
        temp = suffix.get(rangen);
        while (temp.equals(name.toLowerCase())){
            rangen = rand.nextInt(suffix.size());
            temp = suffix.get(rangen);
        }
        name = name + temp;
        return name;
    }

    public String tribeGen(){
        String name = "";
        Random rand = new Random();
        int rangen = rand.nextInt(phrase.size());
        int rangen1 = rand.nextInt(noun1.size());
        int rangen2 = rand.nextInt(noun2.size());
        int rangen3 = rand.nextInt(noun3.size());
        name = phrase.get(rangen);
        name = name.format(name, noun1.get(rangen1), noun2.get(rangen2), noun3.get(rangen3));
        return name;
    }

    public String ancientGen(){
        Random rand = new Random();
        String name = "";
        String temp = "";
        int rangen = rand.nextInt(first.size());
        name = name + first.get(rangen);
        rangen = rand.nextInt(second.size());
        temp = second.get(rangen);
        while (temp.equals(name.toLowerCase())){
            rangen = rand.nextInt(second.size());
            temp = second.get(rangen);
        }
        name = name + " " + temp;
        return name;
    }

    public String miscGen(){ //legacy function from 2015 vers
        String name = "";
        Random rand = new Random();
        int rangen = rand.nextInt(misc.size());
        name = misc.get(rangen);
        return name;
    }


}
