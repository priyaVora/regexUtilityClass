package regexutility;

import static org.junit.Assert.*;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.Test;

import edu.neumont.csc180.cox.regexutil.MyRegexUtility;
import edu.neumont.csc180.cox.regexutil.RegexUtility;
import junit.framework.Assert;

public class RegexUtilityTests {

	@Test
	public void testValidFirstLast() { 
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidHumanName("Ricky Ricardo"));
	}
	
	@Test
	public void testValidFirstOnly() { 
		RegexUtility r = new MyRegexUtility();
		assertFalse(r.isValidHumanName("Madonna"));
	}

	@Test
	public void testValidPhone() { 
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidPhoneNumber("+18-(415)-410-4891"));
	}
	
	
	@Test
	public void testAddress() { 
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidUSStreetAddress("343 South 500 East Apt#. 220"
				+ "\nSalt Lake City, UT 84102"));
	}
	
	@Test
	public void testValidSSN() { 
		RegexUtility r = new MyRegexUtility();
		assertFalse(r.isValidSSN("000-00-0000"));
	}
	

	@Test
	public void testValidSSN1() { 
		RegexUtility r = new MyRegexUtility();
		assertFalse(r.isValidSSN("901-00-6666"));
	}
	
	@Test
	public void testValidSSNTrue() { 
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.isValidSSN("616-34-8395"));
	}
	
	@Test 
	public void testPasswordValidState() { 
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.validatePasswordComplexity("Miracle@89", 10, 1, 6, 2, 1));
	
	}
	@Test 
	public void testGetHtmlTagContents() { 
		RegexUtility r = new MyRegexUtility();
		String boldContents = r.getHTMLTagContents("<html>This is <b>My text</b>!</html>", "b");
		assertTrue(boldContents.equals("My text"));
	}
	@Test 
	public void testGetHtmlTagContentsArray() { 
		RegexUtility r = new MyRegexUtility();
		
		String[] boldContents = r.getHTMLTagsContents("<html>This is <b>My text1</b><b>My text2</b><b>My text3</b>!</html>", "b");
		//assertTrue(boldContents.equals(boldContents[0]));
		assertTrue(boldContents[1].equals("My text2"));
	}
	
	@Test
	public void countContains() { 
		RegexUtility r = new MyRegexUtility();
		assertTrue(r.countContains("<html>This is <b>My text1</b><b>My text2</b><b>My text1</b>!</html>", "text1") == 2);
	}
	
	@Test 
	public void testGetHtmlLinkUrl() { 
		RegexUtility r = new MyRegexUtility();
		
		String [] linkArray = r.getHTMLLinkURL("<a>href= 'firstLink.com'</a><a>href= 'secondLInk.com'</a><a>href = 'thirdLink.com'</a>");
		String [] expected = new String[3];
		System.out.println("LInk.....");
		expected[0] = "href= 'firstLink.com'";
		expected[1] = "href= 'secondLInk.com'";
		expected[2] = "href = 'thirdLink.com'";
		for (int i = 0; i < expected.length; i++) {	
			assertTrue(expected[i].equals(linkArray[i]));
		}
	}

}
