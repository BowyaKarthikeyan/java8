package streamsLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertListToMap {

	public static void main(String[] args) {
		List<ListOfObjects> list = new ArrayList<>();
		list.add(new ListOfObjects(1, "Divya"));
		list.add(new ListOfObjects(5, "Muthu"));
		list.add(new ListOfObjects(3, "Hari"));
		list.add(new ListOfObjects(4, "Sam"));
		list.add(new ListOfObjects(2, "Sharmi"));
		//Filter
		list.stream().filter(x -> x.name.startsWith("S")).forEach(filt -> 
		System.out.println(filt.name));
		//Map Collects
		Map<Integer, String> collectNames = list.stream().collect(Collectors.toMap(ListOfObjects::getId, ListOfObjects::getName));
		System.out.println(collectNames);
		
		//Map
		Map<Integer, String> collectNames1 = list.stream().collect(Collectors.toMap(x -> x.getId(), x ->x.getName()));
		System.out.println(collectNames1);
		
		//Key Sort
		collectNames.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).forEach(System.out::println);
		
		//Value Sort
		collectNames.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).forEach(System.out::println);
		
		Map<Integer, String> newMap = collectNames.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByKey())
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (key, Value) -> key, LinkedHashMap::new));
		
		System.out.println(newMap);

	}

}
