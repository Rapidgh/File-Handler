import java.io.*;

public class SMSfilehandler {

	public static void main(String[] args) {
		 String inputFile = "students.txt";
	        String outputFile = "updated_students.txt";

	       
	        try {
	            File file = new File(inputFile);
	            if (!file.exists()) {
	                FileWriter writer = new FileWriter(file);
	                writer.write("101, John Doe, 20\n");
	                writer.write("102, Jane Smith, 22\n");
	                writer.write("103, Alice Johnson, 21\n");
	                writer.close();
	                System.out.println("students.txt created with sample data.");
	            }
	        } catch (IOException e) {
	            System.out.println("Error creating students.txt");
	            return;
	        }

	        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
	             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	                bw.write(line + "\n");
	            }
	            System.out.println("Student data written to " + outputFile);
	        } catch (FileNotFoundException e) {
	            System.out.println("Error: File not found.");
	        } catch (IOException e) {
	            System.out.println("Error reading or writing file.");
	        }
	}
	
}
	

