/**
 * 
 */
package pythagorasTable;
import java.util.Scanner;

import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Alesia Samylova
 *
 */
public class PythagorasUI {
	

	public enum ZodiacElements {
		WATER,
		FIRE,
		EARTH,
		AIR
	}
	
	public enum ZodiacHoroscopeSigns {
	    ARIES      (1),
	    TAURUS     (2),
	    GEMINI     (3),
	    CANCER     (4),
	    LEO        (5),
	    VIRGO      (6),
	    LIBRA      (7),
	    SCORPIO    (8),
	    SAGITTARIUS(9),
	    CAPRICORN  (10),
	    AQUARIUS   (11),
	    PISCES     (12);
	    private int value;
	    
	    private ZodiacHoroscopeSigns(int value){
	    	this.value = value;
	    }
	}
	public static void readFileToConsole(String fileName){
		try {
			File horoscopeFile = new File(fileName);
			Scanner myReader = new Scanner(horoscopeFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
	
	public static int DigitsCalculation(int number) {
		//Addition of digits in number
		int sum = 0;
		while (number != 0) {
		  int	digit = number % 10;
			sum += digit;
			number /= 10;
		}
		return sum;
	}
	
	public static int CountingDigitsInNumber(int number) {
		int count = 0;
		while (number != 0) {
			count ++;
			number /= 10;
		}
		return count;
	} 

	public static int FirstDigitInNumber(int number) {
		int firstDigitInNumber=0;
	
		while (number != 0) {
			firstDigitInNumber = number % 10;
			number /= 10;
		}

		return firstDigitInNumber;
	}
	
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException{	
		System.out.println("--------------------------------------------------\n"
				           + "Welcome to program of astrological calculations!\n"
				           +"--------------------------------------------------\n"
				           +"Fill in input data of birth");
		Scanner in = new Scanner(System.in);
		System.out.println("Day: ");
		int bDay = in.nextInt();
		System.out.println("Month: ");
		int bMonth = in.nextInt();
		System.out.println("Year: ");
		int bYear = in.nextInt();
		
		System.out.println("--------------------------------------------------\n"
				           + "Your date of birth (Day.Month.Year):\n"
				           + bDay + "." + bMonth + "." + bYear
				           + "\n--------------------------------------------------");
		
		// Leap year calculation
		Boolean isLeapYear = false;
		if ((bYear % 4 != 0) || (bYear % 100 == 0 && bYear % 400 != 0))
			isLeapYear = false;
		else
			isLeapYear = true;
		
		if (isLeapYear) {
			System.out.println("<" + bYear + ">" + " is leap year");
		} else {
			System.out.println("<" + bYear + ">" + " is not leap year");
		}
		String input_date = bDay + "/" + bMonth + "/" + bYear;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = simpleDateFormat.parse(input_date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDate);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String strDayOfWeek = "";
		
		switch (dayOfWeek) {
		case 1: strDayOfWeek = "Sunday"; break;
		case 2: strDayOfWeek = "Monday"; break;
		case 3: strDayOfWeek = "Tuesday"; break;
		case 4: strDayOfWeek = "Wednesday"; break;
		case 5: strDayOfWeek = "Thurday"; break;
		case 6: strDayOfWeek = "Friday"; break;
		case 7: strDayOfWeek = "Saturday"; break;
		default:
		}
		
		System.out.println("Day of Week: <" + strDayOfWeek +">");
		
		System.out.println("--------------------------------------------------\n"
				         + "--------- Zodiacal Sign: ----------");
		// Reading Horoscope
		ZodiacHoroscopeSigns horoscopeSign = ZodiacHoroscopeSigns.ARIES;
		String horoscopeFileName = "src\\horoscopeInfo\\";
		
		if ((bMonth == 3 && bDay >= 21) || (bMonth == 4 && bDay <= 19)) {
			 horoscopeSign = ZodiacHoroscopeSigns.ARIES;
			 horoscopeFileName += "01_aries.txt";
		} else if ((bMonth == 4 && bDay >= 20) || (bMonth == 5 && bDay <= 20)) {
			 horoscopeSign = ZodiacHoroscopeSigns.TAURUS;
			 horoscopeFileName += "02_taurus.txt";
		} else if ((bMonth == 5 && bDay >= 21) || (bMonth == 6 && bDay <= 20 )) {
			horoscopeSign = ZodiacHoroscopeSigns.GEMINI;
			 horoscopeFileName += "03_gemini.txt";
		} else if ((bMonth == 6 && bDay >= 21) || (bMonth == 7 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.CANCER;
			 horoscopeFileName += "04_cancer.txt";
		} else if ((bMonth == 7 && bDay >= 23) || (bMonth == 8 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.LEO;
			 horoscopeFileName += "05_leo.txt";
		} else if ((bMonth == 8 && bDay >= 23) || (bMonth == 9 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.VIRGO;
			 horoscopeFileName += "06_virgo.txt";
		} else if ((bMonth == 9 && bDay >= 23) || (bMonth == 10 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.LIBRA;
			 horoscopeFileName += "07_libra.txt";
		} else if ((bMonth == 10 && bDay >= 23) || (bMonth == 11 && bDay <= 21 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.SCORPIO;
			 horoscopeFileName += "08_scorpio.txt";
		} else if ((bMonth == 11 && bDay >= 22) || (bMonth == 12 && bDay <= 21 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.SAGITTARIUS;
			 horoscopeFileName += "09_sagittarius.txt";
		} else if ((bMonth == 12 && bDay >= 22) || (bMonth == 1 && bDay <= 19 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.CAPRICORN;
			 horoscopeFileName += "10_capricorn.txt";
		} else if ((bMonth == 1 && bDay >= 20) || (bMonth == 2 && bDay <= 18)) {
			 horoscopeSign = ZodiacHoroscopeSigns.AQUARIUS;
			 horoscopeFileName += "11_aquarius.txt";
		} else if ((bMonth == 2 && bDay >= 19) || (bMonth == 3 && bDay <= 20)) {
			 horoscopeSign = ZodiacHoroscopeSigns.PISCES;
			 horoscopeFileName += "12_pisces.txt";
		}
	
		ZodiacElements element;
		switch(horoscopeSign) {
		    case ARIES:
		    case LEO:
		    case SAGITTARIUS:
			   element = ZodiacElements.FIRE;
			   break;
		    case CANCER:
		    case SCORPIO:
		    case PISCES:
		    	element = ZodiacElements.WATER;
		    	break;
		    case TAURUS:
		    case VIRGO:
		    case CAPRICORN:
		    	element = ZodiacElements.EARTH;
		    default:  element = ZodiacElements.AIR;
		}

		System.out.println(horoscopeSign.toString() + "\n");
		System.out.println("This sign has ordinal number equals to " + horoscopeSign.value + "\n");
		
		readFileToConsole(horoscopeFileName);
		System.out.println("--------------------------------------------------\n");
		

		System.out.println("Element: " + element.toString() +"\n");
		readFileToConsole("src\\horoscopeInfo\\" + element.toString().toLowerCase().strip()+"_signs.txt");

		
		
		//Pythagoras Table Calculation
		System.out.println("--------------------------------------------------\n"
        + "------- Pythagoras Magic Square -----");
		int [] workingNumArray = new int[7];

		workingNumArray[0] = bDay;
		workingNumArray[1] = bMonth;
		workingNumArray[2] = bYear;

		//First Working Number Calculation 
		int firstWorkingNumber = DigitsCalculation(bDay) + DigitsCalculation(bMonth);
		firstWorkingNumber += DigitsCalculation(bYear);
		
		System.out.println("First working number: " + firstWorkingNumber);
		workingNumArray[3] = firstWorkingNumber;
		
		//Second Working Number Calculation
		int secondWorkingNumber = DigitsCalculation(firstWorkingNumber);
		System.out.println("Second working number: " + secondWorkingNumber);
		workingNumArray[4] = secondWorkingNumber;
		
		//Third Working Number
		int firstDigitInBirthday = FirstDigitInNumber(bDay);
		int thirdWorkingNumber = firstWorkingNumber - 2*firstDigitInBirthday;
		System.out.println("Third working number: " + thirdWorkingNumber);
		workingNumArray[5] = thirdWorkingNumber;

		//Forth Working Number
		int forthWorkingNumber = DigitsCalculation(thirdWorkingNumber);
		System.out.println("Forth working number: " + forthWorkingNumber);
		workingNumArray[6] = forthWorkingNumber;
		
		//Creating table
		int n = 9;
		int [] PythagorasTable = new int[n];
		for (int i = 0; i < n; i++) {
			PythagorasTable[i] = 0;
		}
		
		int count = 0;
		int m = workingNumArray.length;
		for (int j = 0; j < m; j++) {
			int number = workingNumArray[j];
			while (number != 0) {
				int digit = number % 10;
				if (digit != 0) {
					count ++;
					PythagorasTable[digit-1] +=1;
				}
				number /= 10;
			}
		}

		System.out.println("Your overall lives in Earth is " + count
							+" from maximum (15 lives)");
		for (int i = 0; i < n; i++) {
			System.out.println(" ---" + (i+1) + ": ---");
			System.out.println("|   " + PythagorasTable[i] + "    |");
			System.out.println("|        |");
			if (PythagorasTable[i] == 0) {
				System.out.println("|   -    |");
			} else {
				System.out.print("<");
				for (int j = PythagorasTable[i]; j > 0; j--) {
					System.out.print(i+1);	
				}
				System.out.print(">\n");
			}
			System.out.println("|________|\n");
		}
		
		// Interpretation of results
		System.out.println("-------- Table result interpretation -------");
		for (int i = 0; i < n; i++) {
			if (i+1 == 1) {
				System.out.println("> Square 1 - Character: ");
				switch (PythagorasTable[i]) {
					case 0: System.out.println("  0 - egoist");
							break;
					case 1: System.out.println("  1 - sophisticated egoist"); 
							break;
					case 2: System.out.println("  11 - close to egoism");
							break;
					case 3: System.out.println("  111 - good character, stable");
							break;
					case 4: System.out.println("  1111 - very strong-willed");
							break;
					case 5: System.out.println("  11111 - dictator, petty tyrant");
							break;
					case 6: 
					default: System.out.println("  111111 - (this is rare) crual person, \n"
							+ "  but at the same time for the loved one \n"
							+ "  can do the impossible. It�s very difficult to \n"
							+ "  communicate with such a person" );
					
				} 
			} else if (i+1 == 2) {
				System.out.println("> Square 2 - Bioenergy: ");
				switch (PythagorasTable[i]) {
					case 0: System.out.println("  0 - The absence of twos means the \n"
							+ "  absence of bioenergy, which means that the bioenergy\n"
							+ "  channel is open for intensive energy collection. These\n"
							+ "  people love old things, treat others well, thereby trying\n"
							+ "  to profit from others. Well behaved by nature");
							break;
					case 1: System.out.println("  2 - bioenergy is enough for life,\n"
							+ "  but now, at this stage, its too little, so sports are\n"
							+ "  required. Hypersensitive to atmospheric changes"); 
							break;
					case 2: System.out.println("  22 - bioenergy is enough. A person can heal others");
							break;
					case 3: System.out.println("  222 - person is a good psychic");
							break;
					case 4: 
					default:
							System.out.println("  2222 - These people are very attractive to opposite sex\n"
							+"  But if also three sixes (666) are added - beware of temptations");
				} 
			} else if (i+1 == 3) {
				System.out.println("> Square 3 - Decency:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - this is a very punctual and neat person\n"
						+ "  It stands out among others by its conversation");
						break;
				case 1: System.out.println("  3 - these people are disturbed by a mess,\n"
						+ "  but relatively (if they want to do something, they do it; \n"
						+ "  if they don't want to do something, they don't do it), it all\n"
						+ "  depends on the mood"); 
						break;
				case 2: System.out.println("  33 - these people have the ability to science\n"
						+ "  (wonderful mathematicians, physicists, chemists)");
						break;
				case 3: 
				default:
						System.out.println("  333 - these preople have the abitity to science with\n"
						+ "  double strength. Pedantry, accuracy, if there is no realization\n"
						+ "  in science");
				} 
			} else if (i+1 == 4) {
				System.out.println("> Square 4 - Health:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - this person is very ill");
						break;
				case 1: System.out.println("  4 - this person will not get ill\n"
						+ "  too much, mostly due to old-age"); 
						break;
				case 2: System.out.println("  44 - a very healthy person or has\n"
						+ "  a high temperament");
						break;
				case 3: 
				default:
						System.out.println("  444 - a very healthy person with double energy");
				} 
			} else if (i+1 == 5) {
				System.out.println("> Square 5 - Intuition:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - unopened channel at birth. These people\n"
						+ "  are always trying to undertake something, do something, always\n"
						+ "  in thought, in experiment, in calculations. Life experience shows\n"
						+ "  that many mistakes will be made by this person. It's hard for\n"
						+ "  these people to live. Everything that is given to them, \n"
						+ "  they pierce with their heads");
						break;
				case 1: System.out.println("  5 - the channel is open, these people make fewer mistakes"); 
						break;
				case 2: System.out.println("  55 - highly developed intuition (investigators, lawyers)");
						break;
				case 3: System.out.println("  555 - clairvoyants, everything that happens around them\n"
						+ "  is clear to them. They know what they are doing.");
						break;
				case 4:
				default:
						System.out.println("  5555 - clairvoyants, everything that happens around them\n"
						+ "  is clear to them. There are times when they are on the other side of time\n"
						+ " and space");
				} 
			} else if (i+1 == 6) {
				System.out.println("> Square 6 - Grounding:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - person came to this world to receive a profession,\n"
						+ "  physical labor is necessary, but he does not love it");
						break;
				case 1: System.out.println("  6 - grounded person. Physical labor is necessary.\n"
						+ "  He/she might think about studying"); 
						break;
				case 2: System.out.println("  66 - very grounded, but physical labor is not needed,\n"
						+ "  but person loves it");
						break;
				case 3: System.out.println("  666 - anxious sign. The person is very attractive,\n"
						+ "  temperamental");
						break;
				case 4:
				default:
						System.out.println("  6666 - this person in his/her previous earthly transformations\n"
						+ "  gained a lot of grounding, worked very hard. For this person there\n"
						+ "  is no yoke of physical labor. He always works. Such a person must\n"
						+ "  definitely go to college, especially if there are nines");
				} 
			} else if (i+1 == 7) {
				System.out.println("> Square 7 - Talent:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - this person was born to earn sevens\n"
						+ "  in his/her subsequent transformations. But he/she can earn them only\n"
						+ "  by sympathy. Very hard life");
						break;
				case 1: System.out.println("  7 - a person lives much easier. There is talent,\n"
						+ "  but not strongly marked"); 
						break;
				case 2: System.out.println("  77 - it is a very strong sign, especially if he/she\n"
						+ "  fully develops its strength. The person is musical. Has an artistic\n"
						+ "  taste, can draw");
						break;
				case 3: System.out.println("  777 - special sign. These people will face\n"
						+ "  serious difficulties");
						break;
				case 4:
				default:
						System.out.println("  7777 - sign of anxiety. People with this sign should\n"
						+ "  be very careful.");
				} 
			} else if (i+1 == 8) {
				System.out.println("> Square 8 - Obligation:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - person takes something and is\n"
						+ "  in no hurry to give it back");
						break;
				case 1: System.out.println("  8 - person with a developed sense of responsibility"); 
						break;
				case 2: System.out.println("  88 - a very developed sense of responsibility,\n"
						+ "  there is always a desire to help others");
						break;
				case 3: System.out.println("  888 - a sign of service to the people. Great\n"
						+ "  responsibility. This is a sign of I. Gandhi");
						break;
				case 4:
				default:
						System.out.println("  8888 - people with advanced skills, with inclination\n"
						+ "  to study exact sciences");
				} 
			} else if (i+1 == 9) {
				System.out.println("> Square 9 - Intelligence:");
				switch (PythagorasTable[i]) {
				case 0: System.out.println("  0 - ");
						break;
				case 1: System.out.println("  9 - a person must develop another nine."); 
						break;
				case 2: System.out.println("  99 - a smart head is given from birth, but is\n"
						+ "  reluctant to learn.");
						break;
				case 3: System.out.println("  999 - intelligent person by nature, everything\n"
						+ "  is given to him/her");
						break;
				case 4:
				default:
						System.out.println("  9999 - truth is revealed to man in conjunction\n"
						+ "  with a rare mind, but distinguished by rudeness and no mercy");
				} 
			}
			System.out.println("  --------");
		}
		System.out.println("Press any alphanumeric symbol to close the window...\n");
		while (!in.hasNext()) {
		}
		System.out.println("Bye!");
		in.close();
	}
}
