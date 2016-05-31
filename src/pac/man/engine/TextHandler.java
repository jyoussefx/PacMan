package pac.man.engine;

import java.util.ArrayList;

/**
 * Writes NES-font text at a specified point
 * NOTE: class is only referenced statically
 * Creds to J-chan for the texture coordinates
 * 
 * @author Andrew Faulkenberry
 * @version 
 */


public class TextHandler {

	static ArrayList<char[]> words = new ArrayList<>();
	static ArrayList<Integer> topLeftX = new ArrayList<>();
	static ArrayList<Integer> topLeftY = new ArrayList<>();
	static ArrayList<Integer> fontSizes = new ArrayList<>();
	
	static ArrayList<String> strings = new ArrayList<>();
 	
 	static final int HORIZ_SCALE = 16;
 	static final int VERT_SCALE = 16;
	
	public TextHandler()
	{
		
	}
	
	/**
	 * Prints a given string on-screen at a specified point
	 * @param s The string to be written
	 * @param bottomLeftCornerX The bottom-left horizontal coordinate
	 * @param bottomLeftCornerY The bottom-left vertical coordinate
	 * @param fontSize The size (in pixels) of the font
	 */
	public static void write(String s, int bottomLeftCornerX, int bottomLeftCornerY, int fontSize) 
	{
		words.add(s.toCharArray());
		topLeftX.add(bottomLeftCornerX);
		topLeftY.add(bottomLeftCornerY);
		fontSizes.add(fontSize);
		
		strings.add(s);
	}
	
	/**
	 * Prints a given string on-screen at a specified point, in a standard 16 pt font
	 * @param s The string to be written
	 * @param bottomLeftCornerX The bottom-left horizontal coordinate
	 * @param bottomLeftCornerY The bottom-left vertical coordinate
	 */
	public static void write(String s, int topLeftCornerX, int topLeftCornerY) 
	{
		write(s, topLeftCornerX, topLeftCornerY, 16);
	}
	
	/**
	 * Renders the words in the TextHandler's memory on-screen
	 */
	public static void render()
	{
		if (!words.isEmpty())
		{
			for (char[] letters: words) {
				
				int index = words.indexOf(letters);
				
				int x = topLeftX.get(index);
				int y = topLeftY.get(index);
				int pt = fontSizes.get(index);
				
				
				for (int i=0; i<letters.length; i++)
				{
					
					/*
					 * NOTE: the true case accounts for an apparent LWJGL bug
					 * Without it, the first letter of the first word (only) would be printed too far right and up
					 * If this is a result of error on my part (not LWJGL), let me know
					 */
					
					if (index==0 && i==0)
					{
						Draw.rect(x-112, y-112, pt, pt, getTexX(letters[i]), getTexY(letters[i]), getTexX(letters[i]) + 16, getTexY(letters[i]) + 16, 0, 2);
					} 
					else
					{
						Draw.rect(x, y, pt, pt, getTexX(letters[i]), getTexY(letters[i]), getTexX(letters[i]) + 16, getTexY(letters[i]) + 16, 0, 2);
					}
					x+=pt;
					
				}
			}
		}
	}
	
	/**
	 * 
	 * @param s The character to be found on the texture file
	 * @return The x-coordinate of the given character on the NES-font texture file 
	 */
	public static int getTexX(char s) {
 		int texX = 0;

 		switch (s) {
 		case ' ':case '0':case '@':case 'P':case '`':case 'p':
 			texX = HORIZ_SCALE * 0;
 			break;
 		case '!':case '1':case 'A':case 'Q':case 'a':case 'q':
 			texX = HORIZ_SCALE * 1;
 			break;
 		case '"':case '2':case 'B':case 'R':case 'b':case 'r':
 			texX = HORIZ_SCALE * 2;
 			break;
 		case '#':case '3':case 'C':case 'S':case 'c':case 's':
 			texX = HORIZ_SCALE * 3;
 			break;
 		case '$':case '4':case 'D':case 'T':case 'd':case 't':
 			texX = HORIZ_SCALE * 4;
 			break;
 		case '%':case '5':case 'E':case 'U':case 'e':case 'u':
 			texX = HORIZ_SCALE * 5;
 			break;
 		case '&':case '6':case 'F':case 'V':case 'f':case 'v':
 			texX = HORIZ_SCALE * 6;
 			break;
 		case '\'':case '7':case 'G':case 'W':case 'g':case 'w':
 			texX = HORIZ_SCALE * 7;
 			break;
 		case '(':case '8':case 'H':case 'X':case 'h':case 'x':
 			texX = HORIZ_SCALE * 8;
 			break;
 		case ')':case '9':case 'I':case 'Y':case 'i':case 'y':
 			texX = HORIZ_SCALE * 9;
 			break;
 		case '*':case ':':case 'J':case 'Z':case 'j':case 'z':
 			texX = HORIZ_SCALE * 10;
 			break;
 		case '+':case ';':case 'K':case '[':case 'k':case '{':
 			texX = HORIZ_SCALE * 11;
 			break;
 		case ',':case '<':case 'L':case '\\':case 'l':case '|':
 			texX = HORIZ_SCALE * 12;
 			break;
 		case '-':case '=':case 'M':case ']':case 'm':case '}':
			texX = HORIZ_SCALE * 13;
 			break;
 		case '.':case '>':case 'N':case '^':case 'n':case '~':
			texX = HORIZ_SCALE * 14;
 			break;
 		case '/':case '?':case 'O':case '_':case 'o':
			texX = HORIZ_SCALE * 15;
 			break;
 		default:
 			texX = HORIZ_SCALE * 16;
 			break;
 		}

 		return texX;
 	}

	/**
	 * 
	 * @param s The character to be found on the texture file
	 * @return The y-coordinate of the given character on the NES-font texture file 
	 */
 	public static int getTexY(char s) {

 		int texY = 0;

 		switch (s) {
 		//first row
 		case ' ':case '!':case '"':case '#':case '$':case '%':case '&':case '\'':
 		case '(':case ')':case '*':case '+':case ',':case '-':case '.':case '/':
 			texY = VERT_SCALE*0;
 			break;
 		//2 row
 		case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':
 		case '8':case '9':case ':':case ';':case '<':case '=':case '>':case '?':
 			texY = VERT_SCALE*1;
 			break;
 		//3 row
 		case '@':case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':case 'G':
 		case 'H':case 'I':case 'J':case 'K':case 'L':case 'M':case 'N':case 'O':
 			texY = VERT_SCALE*2;
 			break;
 		//4 row
 		case 'P':case 'Q':case 'R':case 'S':case 'T':case 'U':case 'V':case 'W':
 		case 'X':case 'Y':case 'Z':case '[':case '\\':case ']':case '^':case '_':
			texY = VERT_SCALE*3;
 			break;
 		//5 row
 		case '`':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':
  		case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':
  			texY = VERT_SCALE*4;
 			break;
 		//6 row
 		case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':
		case 'x':case 'y':case 'z':case '{':case '|':case '}':case '~':
		  	texY = VERT_SCALE*5;
 			break;
 		default:
 			texY = VERT_SCALE * 0;
 			break;
 		}

 		return texY;
 	}
 	
 	/**
 	 * Clears the entire TextHandler's memory
 	 */
 	public static void clear()
 	{
 		words.clear();
 		topLeftX.clear();
 		topLeftY.clear();
 		fontSizes.clear();
 		strings.clear();
 	}
 	
 	/**
 	 * Erases a given word and replaces it with another word in the same location
 	 * @param erase The word to be replaced
 	 * @param replace The word with which the erased word is to be replaced
 	 * @throws NonexistentStringExcpetion
 	 */
 	public static void overwrite(String erase, String replace) throws NonexistentStringException
 	{
 		int index = strings.indexOf(erase);
 		if (index==-1)
 		{
 			throw new NonexistentStringException("The given string does not exist in the TextHandler's memory.");
 		} else
 		{
 			words.set(index, replace.toCharArray());
 			strings.set(index, replace);
 		}
 		
 	
 	}
 	
 	/**
 	 * Erases a specific word from the TextHandler's memory
 	 * @param erase The word to be erased
 	 * @throws NonexistentStringException
 	 */
 	public static void erase(String erase) throws NonexistentStringException
 	{
 		int index = strings.indexOf(erase);
 		if (index==-1)
 		{
 			//will throw an exception
 			throw new NonexistentStringException("The given string does not exist in the TextHandler's memory.");
 		} else
 		{
 			words.remove(index);
 			strings.remove(index);
 		}
 	}
 
}
