import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;



public class StreamsPractice {

	
	public static void main(String[] args) {
		regular();
		System.out.println("");
		streamFilter();
		System.out.println("");
		streamMap();
		System.out.println("");
		streamCollect();
		System.out.println("");
		streamAssignment();
	}
	
	
	
	//Count the number of names starting with alphabet A in list - regular 
	public static void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abdullah");
		names.add("Ege");
		names.add("Burcu");
		names.add("Ares");
		names.add("Boris");
		int count=0;
		for (String actual : names) {
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	
	//Count the number of names starting with alphabet A in list - streams
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abdullah");
		names.add("Ege");
		names.add("Burcu");
		names.add("Ares");
		names.add("Boris");
		//convert arraylist to stream and filter with a simple lambda function
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		//same operation with stream creation rather than converting from a collection
		Long d = Stream.of("Abdullah","Ege","Burcu","Ares","Boris").filter(s->{
			return s.startsWith("A") && s.endsWith("s");
		}).count();
		System.out.println(d);
		//print all the names of arraylist which has length more than 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	
	
	//Print the names which have last letter as "s" with Uppercase - streams (map + filter + anyMatch)
	public static void streamMap() {
		Stream.of("Abdullah","Ege","Burcu","Ares","Boris")
		.filter(s->s.endsWith("s"))
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//convert array to list then create a stream to apply intermediate operations 
		List<String> names1 = Arrays.asList("Abdullah","Ege","Burcu","Ares","Boris");
		names1.stream()
		.filter(s->s.startsWith("A"))
		.sorted()
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//merge two lists by concatenating two streams 
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Mert");
		names2.add("Damla");
		names2.add("Kemal");
		
		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//check if anything is present in the stream with anyMatch 
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("ares"));
		System.out.println("\n" + flag);
		Assert.assertTrue(flag);
		
		//filter vs anyMatch
		//filter returns a substream wrt applied condition
		//whereas anyMatch returns boolean if the condition true or false
	}

	
	
	//Make manipulations on the list and convert it back to list again - streams (collect)
	public static void streamCollect() {
		List<String> namesList = Stream.of("Abdullah","Ege","Burcu","Ares","Boris","Ahmet","Mehmet","Ayça")
				.filter(s->s.startsWith("A"))
				.map(s->s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(namesList.get(0) + "\n" + namesList.get(2));
		
	}



	//Sort the unique values of the elements present in the array, and print the third element - streams (distinct + sorted + collect)
	public static void streamAssignment() {
		List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
		//numbers.stream().distinct().forEach(s->System.out.println(s)); //print unique elements of the stream with 'distinct'
		List<Integer> listNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(listNumbers.get(2)); //print the third unique value 
	}
}
