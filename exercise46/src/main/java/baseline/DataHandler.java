package baseline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataHandler {
    private HashMap<String,Integer> data = new HashMap<>();

    public void getInputFromTxtFile() {
        //scans file and adds words to hashmap, incrementing the value by 1
        String buffer;
        try (Scanner in = new Scanner(new FileReader("data/exercise46_input.txt"))) {
            while(in.hasNext()) {
                buffer = in.next();
                data.putIfAbsent(buffer,0);
                data.replace(buffer,data.get(buffer)+1);
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void outputHistogramAsGreatestToLeast() {
        //sort hash map
        sortDataByValue();
        //output the hashmap using a formatter
        outputDataToFileAsTabularHistogram();
    }

    private void outputDataToFileAsTabularHistogram() {
        try (Formatter out = new Formatter("data/output.txt")) {
            AtomicInteger line= new AtomicInteger();
            data.forEach((key,value)-> {
                if(line.get() >0)
                    out.format("%n");
                out.format("%-10s",key+":");
                for (int i = 0; i < value; i++) {
                    out.format("%s","*");
                }
                line.getAndIncrement();
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sortDataByValue() {
        List<Map.Entry<String,Integer>> list = new LinkedList<>(data.entrySet());
        //sort the linked list
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        data = list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b) -> b, LinkedHashMap::new));
    }

    public Map<String,Integer> returnDataFromHashMap() {
        return data;
    }
}
