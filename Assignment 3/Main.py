# convert this to python

# Importing 'math' library
from math import pi
from decimal import Decimal

def isPalindrome(num):
    # string str = intToString(num)
	int_str = str(num)
	reversed = int_str[::-1]
    # for (int i = str.length() - 1; i >= 0 ; i-- )
	if int_str == reversed:
		return int_str

#private static int areaSquare(int width) {
    #	return width * width;
	#}
def areaSquare(width):
    #return width * width
	return pow(width,2)

#private static double areaCircle(double radius) {
    #		return PI * (radius * radius);
	#}
def areaCircle(radius):
	#return PI * (radius * radius)
	# getcontext().prec = 5
	# round to 5 decimal places
	area = round(Decimal(pi) * pow(radius,2),5)
	return area

#import java.util.Scanner;
#public class Main {
	
#static Scanner scanner = new Scanner(System.in);
# 5 places..
#PI = 3.14159;

	#public static void main(String[] args) {

		# Display menu
		#System.out.println("Calculations");
print("Calculations")
		#System.out.println("1. Calculate area of a square");
print("1. Calculate area of a square")
		#System.out.println("2. Calculate area of a circle");
print("2. Calculate area of a circle")
		#System.out.println("3. Display palindromes up to 1,000");
print("3. Display palindromes up to 1,000")

		# // Get input
		#System.out.print("Enter an option: ");
		#int option = scanner.nextInt();
option = input("Enter an option: ")
 # if 1 <= int(option) <= 3:
			#switch(option) {
match option:
				case "1": #{
					#System.out.println("\n**** Area of a square ****");
					print("\n**** Area of a square ****")
					#System.out.print("Enter width of square (cm): ");
					width = input("Enter width of square (cm): ")					
					#int width = scanner.nextInt();					
					#System.out.println("The area of a square of " + width + "cm = " + areaSquare(width) + "cm squared");
					print("The area of a square of {0} cm = {1} cm squared".format(width, areaSquare(int(width))))
					#break
					#}
				case "2": #{
					#System.out.println("\n**** Area of a circle ****");
					print("\n**** Area of a circle ****")
					#System.out.print("Enter radius of circle (cm): ");
					radius = float()
					radius = input("Enter radius of circle (cm): ")
					#double radius = scanner.nextDouble();					
					#System.out.println("The area of a square of " + radius + "cm = " + areaCircle(radius) + "cm squared");
					print("The area of a square of {0} cm = {1} cm squared".format(radius,areaCircle(Decimal(radius))))
					#break;
				#}
				case "3": #{
					#System.out.println("\n**** Palindromes ****");
					print("\n**** Palindromes ****")
					for i in range(0,1000):
					#for(i = 0; i <= 1000; i++) {
						if isPalindrome(i):
							#System.out.println(i)
							print("{0}".format(i))
				case _:
					print("Invalid option")
					#}
					#break;
				#}
			#}
		#} 
# else: {
			#System.out.println("Invalid option");
		#}
	#}

#	private static boolean isPalindrome(int num) {
#		String str = Integer.toString(num);
#		String reverse = "";
#		for(int i = str.length() - 1; i >= 0; i--) {
#			reverse += str.charAt(i);
#		}
#		return str.equals(reverse);
#	}
	

#}


