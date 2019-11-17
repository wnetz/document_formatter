package format;

enum Alignment { left, right, center, equal; }

public class TextFormatter {

	public static void main(String[] args) {
		Alignment alignTo = Alignment.left;
		boolean dblSpace = false, dblCol = false, wrapTxt = false; // Default setting.
		final int defLineLen = 80, minLen = 10, maxLen = 200; //Change maxLen based off of Jah's recommendation.
		int lineLen = defLineLen; // Default setting.
		
		
		
		
		String str = "-w-";
		
		if ((str.substring(0,1)).equals("-")) {
			switch (str.substring(0, 2)) {
				case "-n":
					str = (str.substring(2, str.length()).trim());
					if (Integer.parseInt(str) >= minLen && Integer.parseInt(str) <= maxLen) { lineLen = Integer.parseInt(str); }
					else { System.out.printf("Line lengths must fall between " + minLen + "-" + maxLen + "."); }
					break;
					
				case "-l":
					alignTo = Alignment.left;
					break;
					
				case "-r":
					alignTo = Alignment.right;
					break;
				
				case "-c":
					alignTo = Alignment.center;
					break;
					
				case "-e":
					alignTo = Alignment.equal;
					break;
					
				case "-w":
					str = (str.substring(2, str.length()).trim());
					
					if (str.equals("+")) { wrapTxt = true; }
					else if(str.equals("-")) { wrapTxt = false; }
					break;
					
				case "-s":
					dblSpace = false;
					break;
					
				case "-d":
					dblSpace = true;
					break;
			}
			
			if (str == "-t") {
				//Call Center and underline here
			}
			
			else if (str == "-p") {
				str = (str.substring(2, str.length()).trim());
				//n = Integer.parseInt(str);
				//Add 'n' number of spaces to the following line.
			}
			
			else if (str == "-b") {
				str = (str.substring(2, str.length()).trim());
				//n = Integer.parseInt(str);
				//Enter 'n' number of new lines.
			}
			
			else if (str == "-a") {
				str = (str.substring(2, str.length()).trim());
				if (Integer.parseInt(str) == 1 || Integer.parseInt(str) == 2) {
					//1-Col = 1/80, 2-Col = 35/10/35, revert back to default line len. 
				}
			}
			
		}
		
		else {
			if (alignTo == Alignment.left) { } //<call align left
			else if (alignTo == Alignment.right) {} //<call align right
			else if (alignTo == Alignment.center) {} //<call align center
			else if (alignTo == Alignment.equal) {} //<call align equal
		
			if (dblSpace == true) {} // enter a line after the current line
			
			if (wrapTxt == true) {} // read in (maxLen - str.length()) from the next line and append to the current line 

		}
	}
}