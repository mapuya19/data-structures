package project5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

//import project5.MeteoriteData;
//import project5.Meteorite;

//For eclipse
//right-click project folder
//properties
//java build path
//add library
//junit
//junit4
//apply and close

public class Testing {
	@Test
    public void BST_contains_nullInput() {
		
		try {
			BST<String> tree1 = new BST<>();
        	tree1.contains(null);
        	fail("A NullPointerException should have been thrown");
        }
        catch(NullPointerException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_nullInput1() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(11);
			tree1.add(15);
			tree1.add(2);
        	tree1.contains(null);
        	fail("A NullPointerException should have been thrown");
        }
        catch(NullPointerException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	
	@Test
    public void BST_contains_StringFromEmptyIntegerTree() {
		//I am assuming that this is correct. Not very sure about this test.
		//	Depends on what the professor wants.
		//Since the tree is empty, the values inside the tree are undetermined yet
		//	Since a string is part of <T extends Comparable<?>>, the string ("10") could be 
		//	compared to the empty tree and will definitely return false. However, a 
		//	ClassCastException will be thrown once something gets added to the tree.
		try {
			BST<Integer> tree1 = new BST<>();
        	assertEquals("Returned value should be false", tree1.contains("10"), false);
        	//tree1.add(1);
        	//tree1.contains("10");
        	//fail("A ClassCastException should have been thrown");
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_notComparable() {
		//I am assuming that this is correct. Not very sure about this test.
		//	Depends on what the professor wants.
		//This test throws exception because arraylist is not <T extends Comparable<?>>
		try {
			BST<Integer> tree1 = new BST<>();
        	tree1.contains(new ArrayList<>());
        	fail("A ClassCastException should have been thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_notComparable1() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(1);
        	tree1.contains(new ArrayList<>());
        	fail("A ClassCastException should have been thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_notComparable2() {

		try {
			BST<String> tree1 = new BST<>();
			tree1.add("1");
        	tree1.contains(new ArrayList<>());
        	fail("A ClassCastException should have been thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_notComparable3() {

		try {
			BST<String> tree1 = new BST<>();
			tree1.add("1");
        	tree1.contains(new Object[1]);
        	fail("A ClassCastException should have been thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_notComparable4() {

		try {
			BST<String> tree1 = new BST<>();
			tree1.add("1");
			Object[] string = {"1"};
        	tree1.contains(string);
        	fail("A ClassCastException should have been thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_notComparable5() {

		try {
			BST<String> tree1 = new BST<>();
			tree1.add("1");
			String[] string = {"1"};
        	tree1.contains(string);
        	fail("A ClassCastException should have been thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid1() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(11);
			tree1.add(15);
			tree1.add(2);
        	assertEquals("Should be true", tree1.contains(10), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid2() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(10), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid3() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(2), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid4() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(5), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid5() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(7), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid6() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(11), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	
	@Test
    public void BST_contains_valid7() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(12), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	@Test
    public void BST_contains_valid8() {

		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(2);
			tree1.add(7);
			tree1.add(12);
			tree1.add(11);
			tree1.add(15);

        	assertEquals("Should be true", tree1.contains(15), true);
        }
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	
	@Test
    public void BST_contains_StringFromInteger() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(10);
			tree1.add(5);
			tree1.add(11);
			tree1.add(15);
			tree1.add(2);
        	tree1.contains("10");
        	fail("A ClassCastException should have be thrown");
        }
        catch(ClassCastException ex) {}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
    }
	
	
	@Test
    public void BST_isEmpty_emptyTree1() {
		
		try {
			BST<String> tree1 = new BST<>();
			assertEquals("Expected output should be true", tree1.isEmpty(), true);
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
    public void BST_isEmpty_emptyTree2() {
		
		try {
			BST<Integer> tree2 = new BST<>();
			assertEquals("Expected output should be true", tree2.isEmpty(), true);
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
    public void BST_isEmpty_Tree1() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("str");
			assertEquals("Expected output should be true", tree1.isEmpty(), false);
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
    public void BST_isEmpty_Tree2() {
		try {
			BST<Integer> tree2 = new BST<>();
			tree2.add(12);
			assertEquals("Expected output should be true", tree2.isEmpty(), false);
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
    public void BST_empty_itr_hasNext() {
		
		try {
			BST<String> tree1 = new BST<>();
	        Iterator<String> itr = tree1.iterator();
	        assertEquals("Empty tree iterator should not return true for hasNext()", 
	        		itr.hasNext(), false);
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
	public void BST_itr_next2() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        
	        Iterator<String> itr = tree1.iterator();
	        
	        assertEquals("Wrong iteration of 1 element", 
	        		itr.next().equals("salmon"), true);
	        
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_itr_next() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        tree1.add("flounder");
	        tree1.add("grouper");
	        tree1.add("cod");
	        tree1.add("carp");
	        tree1.add("tilapia");
	        tree1.add("catfish");
	        tree1.add("bluefish");
	        tree1.add("tuna");
	        tree1.add("yellowtail");
	        tree1.add("herring");
	        tree1.add("sturgeon");
	        Iterator<String> itr = tree1.iterator();
	        Object[] arr = {"bluefish", "carp", "catfish", "cod", 
	        		"flounder", "grouper", "herring", "salmon", 
	        		"sturgeon", "tilapia", "tuna", "yellowtail"};
	        for (int i = 0; i < 12; i++) {
	        	if (!itr.next().equals(arr[i]))
	        		fail("Wrong order of iteration");
	        }
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	
	@Test
    public void BST_itr_Tree2() {
		try {
			BST<Integer> tree2 = new BST<>();
			tree2.add(1);
			tree2.add(2);
			tree2.add(3);
			tree2.add(4);
			tree2.add(8);
			tree2.add(7);
			tree2.add(6);
			tree2.add(5);
			Iterator<Integer> itr = tree2.iterator();
			int[] arr = {1,2,3,4,5,6,7,8};
			for (int i = 0; i < 8; i++) {
				if (itr.next() != arr[i])
					fail("Wrong iteration order");
			}
			if (itr.hasNext())
				fail("There should not be any elements remaining");
			
        	if (tree2.isEmpty() == true)
        		fail("Itr should not eliminate the tree");
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	
	@Test
    public void BST_getRange_nullparam1() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.getRange(null, null);
			fail("A NullPointerException should have been thrown");
	    }
		catch (NullPointerException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_nullparam2() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.getRange(null, "12");
			fail("A NullPointerException should have been thrown");
	    }
		catch (NullPointerException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_nullparam3() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.getRange("12", null);
			fail("A NullPointerException should have been thrown");
	    }
		catch (NullPointerException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_emptyTree1() {
		
		try {
			BST<String> tree1 = new BST<>();
			ArrayList<String> str = tree1.getRange(" ", "zzzzzzzzzzzz");
			assertEquals("Empty tree should not produce an non-empty ArrayList", str.size(), 0);

	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_emptyTree2() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			ArrayList<Integer> str = tree1.getRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
			assertEquals("Empty tree should not produce an non-empty ArrayList", str.size(), 0);
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_invalidparam1() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.getRange(Integer.MAX_VALUE, Integer.MIN_VALUE);
			fail("IllegalArgumentException expected");
		}
		catch(IllegalArgumentException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_invalidparam2() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.getRange(0, -1);
			fail("IllegalArgumentException expected");
		}
		catch(IllegalArgumentException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_invalidparam3() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.getRange("b", "a");
			fail("A IllegalArgumentException should have been thrown");
		}
		catch(IllegalArgumentException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_validparam1() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.getRange("a", "a");
		}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_validparam2() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.getRange(0, 0);
		}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_validresult1() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("a");
			if (tree1.getRange("a", "a").size() != 1)
				fail("ArrayList should only contain 1 element");
			if (!tree1.getRange("a", "a").get(0).equals("a"))
				fail ("ArrayList should only contain \"a\" as the element");
		}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_validresult3() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("a");
			tree1.add("b");
			if (tree1.getRange("a", "a").size() != 1)
				fail("ArrayList should only contain 1 element");
			if (!tree1.getRange("a", "a").get(0).equals("a"))
				fail ("ArrayList should only contain \"a\" as the element");
		}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	
	@Test
    public void BST_getRange_validresult2() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(1);
			tree1.add(0);
			if (tree1.getRange(1, 1).size() != 1)
				fail("ArrayList should only contain 1 element");
			if (tree1.getRange(0, 0).get(0) != 0)
				fail ("ArrayList should only contain \"a\" as the element");
			if (tree1.getRange(5, 5).size() != 0)
				fail ("ArrayList should be empty for finding "
						+ "nonexistent values");
		}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_validresult5() {
		
		try {
			BST<Integer> tree1 = new BST<>();
			tree1.add(1);
			tree1.add(0);
			tree1.add(5);
			if (tree1.getRange(0, 1).size() != 2)
				fail("ArrayList should only contain 2 element");
			if (tree1.getRange(0, 1).get(0) != 0)
				fail ("ArrayList should contain 0 as the first element");
			if (tree1.getRange(0, 5).get(2) != 5)
				fail ("ArrayList should contain 5 as the last element");
		}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	
	@Test
    public void BST_getRange_validRange6() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        tree1.add("flounder");
	        tree1.add("grouper");
	        tree1.add("cod");
	        tree1.add("carp");
	        tree1.add("tilapia");
	        tree1.add("catfish");
	        tree1.add("bluefish");
	        tree1.add("tuna");
	        tree1.add("yellowtail");
	        tree1.add("herring");
	        tree1.add("sturgeon");
	        ArrayList<String> arr1 = tree1.getRange("bluefish", "yellowtail");
	        if (arr1.size() != 12)
	        	fail("Not all elements were added to arraylist");
	        Object[] arr = {"bluefish", "carp", "catfish", "cod", 
	        		"flounder", "grouper", "herring", "salmon", 
	        		"sturgeon", "tilapia", "tuna", "yellowtail"};
	        for (int i = 0; i < 12; i++) {
	        	if (!arr1.get(i).equals(arr[i]))
	        		fail("Wrong order of values in ArrayList");
	        }
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	@Test
    public void BST_getRange_validRange7() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        tree1.add("flounder");
	        tree1.add("grouper");
	        tree1.add("cod");
	        tree1.add("carp");
	        tree1.add("tilapia");
	        tree1.add("catfish");
	        tree1.add("bluefish");
	        tree1.add("tuna");
	        tree1.add("yellowtail");
	        tree1.add("herring");
	        tree1.add("sturgeon");
	        ArrayList<String> arr1 = tree1.getRange("bluefish", "bluefish");
	        if (arr1.size() != 1)
	        	fail("There should only be 1 element in ArrayList");
	        Object[] arr = {"bluefish"};
	        if (!arr1.get(0).equals(arr[0]))
	        	fail("Wrong element added to ArrayList");
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_getRange_validRange8() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        tree1.add("flounder");
	        tree1.add("grouper");
	        tree1.add("cod");
	        tree1.add("carp");
	        tree1.add("tilapia");
	        tree1.add("catfish");
	        tree1.add("bluefish");
	        tree1.add("tuna");
	        tree1.add("yellowtail");
	        tree1.add("herring");
	        tree1.add("sturgeon");
	        ArrayList<String> arr1 = tree1.getRange("bluefish", "cod");
	        if (arr1.size() != 4)
	        	fail("There should only be 4 elements in ArrayList");
	        Object[] arr = {"bluefish", "carp", "catfish", "cod"};
	        for (int i = 0; i < 4; i++) {
	        	if (!arr1.get(i).equals(arr[i]))
	        		fail("Wrong order of values in ArrayList");
	        }
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	
	@Test
    public void BST_first_nullroot() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.first();
	        fail("An NoSuchElementException should have been thrown");
	    }
		catch(NoSuchElementException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_first_valid() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        tree1.add("flounder");
	        tree1.add("grouper");
	        tree1.add("cod");
	        tree1.add("carp");
	        tree1.add("tilapia");
	        tree1.add("catfish");
	        tree1.add("bluefish");
	        tree1.add("tuna");
	        tree1.add("yellowtail");
	        tree1.add("herring");
	        tree1.add("sturgeon");
	        String str = tree1.first();
	        if (!str.equals("bluefish"))
	        	fail("Wrong first element");
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	
	@Test
    public void BST_first_valid2() {
		try {
			BST<Integer> tree2 = new BST<>();
			tree2.add(1);
			tree2.add(2);
			tree2.add(3);
			tree2.add(4);
			tree2.add(8);
			tree2.add(7);
			tree2.add(6);
			tree2.add(5);
			int val = tree2.first();
			if (val != 1)
				fail("Wrong first element");
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
    public void BST_last_nullroot() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.last();
	        fail("An NoSuchElementException should have been thrown");
	    }
		catch(NoSuchElementException ex) {}
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	@Test
    public void BST_last_valid() {
		
		try {
			BST<String> tree1 = new BST<>();
			tree1.add("salmon");
	        tree1.add("flounder");
	        tree1.add("grouper");
	        tree1.add("cod");
	        tree1.add("carp");
	        tree1.add("tilapia");
	        tree1.add("catfish");
	        tree1.add("bluefish");
	        tree1.add("tuna");
	        tree1.add("yellowtail");
	        tree1.add("herring");
	        tree1.add("sturgeon");
	        String str = tree1.last();
	        if (!str.equals("yellowtail"))
	        	fail("Wrong last element");
	    }
        catch(Exception ex) {
        	fail("Unexpected exception thrown.");
        }
    }
	
	
	@Test
    public void BST_last_valid2() {
		try {
			BST<Integer> tree2 = new BST<>();
			tree2.add(1);
			tree2.add(2);
			tree2.add(3);
			tree2.add(4);
			tree2.add(8);
			tree2.add(7);
			tree2.add(6);
			tree2.add(5);
			int val = tree2.last();
			if (val != 8)
				fail("Wrong last element");
        }
        catch(Exception ex) {
        	fail("Unexpected exception thrown");
        }
    }
	
	@Test
	public void BST_equals_valid() {
		try {
			BST<String> tree = new BST<>();
	        tree.add("salmon");
	        tree.add("flounder");
	        tree.add("grouper");
	        tree.add("cod");
	        tree.add("carp");
	        tree.add("tilapia");
	        tree.add("catfish");
	        tree.add("bluefish");
	        tree.add("tuna");
	        tree.add("yellowtail");
	        tree.add("herring");
	        tree.add("sturgeon");

	        BST<String> ntree = new BST<>();

	        ntree.add("salmon");
	        ntree.add("flounder");
	        ntree.add("grouper");
	        ntree.add("cod");
	        ntree.add("carp");
	        ntree.add("tilapia");
	        ntree.add("catfish");
	        ntree.add("bluefish");
	        ntree.add("tuna");
	        ntree.add("yellowtail");
	        if (tree.equals(ntree))
	        	fail("Tree is not equal at this point");
	        ntree.add("herring");
	        ntree.add("sturgeon");
		}
		catch (Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_equals_valid2() {
		try {
			BST<String> tree = new BST<>();
	        tree.add("salmon");
	        tree.add("flounder");
	        tree.add("grouper");
	        tree.add("cod");
	        tree.add("carp");
	        tree.add("tilapia");
	        tree.add("catfish");
	        tree.add("bluefish");
	        tree.add("tuna");
	        tree.add("yellowtail");
	        tree.add("herring");
	        tree.add("sturgeon");

	        BST<String> ntree = new BST<>();
	        if (tree.equals(ntree))
	        	fail("Tree is not equal at this point");
		}
		catch (Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_equals_valid3() {
		try {
			BST<String> tree = new BST<>();
	        tree.add("salmon");
	        tree.add("flounder");
	        tree.add("grouper");
	        tree.add("cod");
	        tree.add("carp");
	        tree.add("tilapia");
	        tree.add("catfish");
	        tree.add("bluefish");
	        tree.add("tuna");
	        tree.add("yellowtail");
	        tree.add("herring");
	        tree.add("sturgeon");

	        BST<String> ntree = new BST<>();

	        ntree.add("salmon");
	        ntree.add("flounder");
	        ntree.add("grouper");
	        ntree.add("cod");
	        ntree.add("carp");
	        ntree.add("tilapia");
	        ntree.add("catfish");
	        ntree.add("bluefish");
	        ntree.add("tuna");
	        ntree.add("yellowtail");
	        ntree.add("herring");
	        ntree.add("sturgeon");
	        if (!tree.equals(ntree))
	        	fail("Tree is equal at this point");
		}
		catch (Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_equals_valid4() {
		try {
			BST<String> tree = new BST<>();
	        tree.add("salmon");
	        tree.add("flounder");
	        tree.add("grouper");
	        tree.add("cod");
	        tree.add("carp");
	        tree.add("tilapia");
	        tree.add("catfish");
	        tree.add("bluefish");
	        tree.add("tuna");
	        tree.add("yellowtail");
	        tree.add("herring");
	        tree.add("sturgeon");
	        if (!tree.equals(tree))
	        	fail("Tree is equal to itself");
		}
		catch (Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	
	@Test
	public void BST_equals_valid5() {
		try {
			BST<String> tree = new BST<>();
	        tree.add("salmon");
	        tree.add("flounder");
	        tree.add("grouper");
	        tree.add("cod");
	        tree.add("carp");
	        tree.add("tilapia");
	        tree.add("catfish");
	        tree.add("bluefish");
	        tree.add("tuna");
	        tree.add("yellowtail");
	        tree.add("herring");
	        tree.add("sturgeon");

	        BST<Integer> tree2 = new BST<>();

	        tree2.add(1);
			tree2.add(2);
			tree2.add(3);
			tree2.add(4);
			tree2.add(8);
			tree2.add(7);
			tree2.add(6);
			tree2.add(5);
	        if (tree.equals(tree2))
	        	fail("Trying to compare integer with string");
		}
		catch (Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_equals_emptytrees() {
		try {
			BST<String> tree = new BST<>();
			BST<Integer> tree2 = new BST<>();
			if (!tree.equals(tree2))
				fail("2 empty trees are equal");
			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
	}
	
	@Test
	public void BST_equals_valid1() {
		try {
			BST<String> tree = new BST<>();
			BST<Integer> tree2 = new BST<>();
			tree2.add(1);
			if (tree.equals(tree2))
				fail("the 2 trees are not equal");
			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
	}
	
	@Test
	public void BST_toString_valid1() {
		try {
			BST<String> tree = new BST<>();
			tree.add("salmon");
	        tree.add("flounder");
	        tree.add("grouper");
	        tree.add("cod");
	        tree.add("carp");
	        tree.add("tilapia");
	        tree.add("catfish");
	        tree.add("bluefish");
	        tree.add("tuna");
	        tree.add("yellowtail");
	        tree.add("herring");
	        tree.add("sturgeon");
			String str = "[bluefish, carp, catfish, cod, "
					+ "flounder, grouper, herring, salmon, "
					+ "sturgeon, tilapia, tuna, yellowtail"
					+ "]";
			if (!tree.toString().equals(str))
				fail("Incorrect string for toString() returned");			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
	}
	
	
	@Test
	public void BST_toString_valid2() {
		try {
			BST<Integer> tree2 = new BST<>();

	        tree2.add(1);
			tree2.add(2);
			tree2.add(3);
			tree2.add(4);
			tree2.add(8);
			tree2.add(7);
			tree2.add(6);
			tree2.add(5);
			String str = "[1, 2, 3, 4, 5, 6, 7, 8]";
			if (!tree2.toString().equals(str))
				fail("Incorrect string for toString() returned");			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_toString_emptyTree() {
		try {
			BST<Integer> tree2 = new BST<>();

			String str = "[]";
			if (!tree2.toString().equals(str))
				fail("Incorrect string for toString() returned");			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_toString_emptyTree2() {
		try {
			BST<String> tree2 = new BST<>();

			String str = "[]";
			if (!tree2.toString().equals(str))
				fail("Incorrect string for toString() returned");			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_toArray_emptyTree() {
		try {
			BST<Integer> tree2 = new BST<>();
			Object[] arr = tree2.toArray();
			if (arr.length != 0) 
				fail("Empty tree should return empty array");
			
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
	@Test
	public void BST_toArray_Tree() {
		try {
			BST<Integer> tree2 = new BST<>();

	        tree2.add(1);
			tree2.add(2);
			tree2.add(3);
			tree2.add(4);
			tree2.add(8);
			tree2.add(7);
			tree2.add(6);
			tree2.add(5);
			Object[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
			Object[] arr2 = tree2.toArray();
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != arr2[i])
					fail("Wrong order of elements of the array");
			}	
		}
		catch(Exception ex) {
			fail("Unexpected exception thrown");
		}
		
	}
	
}
