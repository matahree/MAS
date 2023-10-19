//package xor;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class XORTest {
//
//
//    // MAKE A S
//    @Test
//    public void testXOR() {
//        Lawyer lawyer1 = new Lawyer("Alice");
//        Lawyer lawyer2 = new Lawyer("Bob");
//        Lawyer lawyer3 = new Lawyer("Charlie");
//
//        LawFirm lawFirm1 = new LawFirm("Doe & Co", "123456789");
//        LawFirm lawFirm2 = new LawFirm("Smith & Partners", "987654321");
//
//        Court court1 = new Court("District Court", "123 Main St");
//        Court court2 = new Court("Superior Court", "456 Oak Ave");
//
//        // Add lawyers to law firms
//        lawFirm1.addLawyer(lawyer1);
//        lawFirm1.addLawyer(lawyer2);
//        lawFirm2.addLawyer(lawyer3);
//
//        // Verify that lawyers are assigned to the correct law firms
//        assertEquals(lawFirm1, lawyer1.getEmployerLawFirm());
//        assertEquals(lawFirm1, lawyer2.getEmployerLawFirm());
//        assertEquals(lawFirm2, lawyer3.getEmployerLawFirm());
//
//        // Try to assign a lawyer to a different law firm (should throw an exception)
//        try {
//            lawFirm2.addLawyer(lawyer1);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("This lawyer is already assigned to a law firm.", e.getMessage());
//        }
//
//        // Add lawyers to courts
//        court1.addLawyer(lawyer1);
//        court1.addLawyer(lawyer3);
//
//        // Verify that lawyers are assigned to the correct courts
//        assertEquals(court1, lawyer1.getEmployerCourt());
//        assertEquals(court1, lawyer3.getEmployerCourt());
//
//        court2.addLawyer(lawyer2);
//        // Verify that lawyers are assigned to the correct courts
//        assertEquals(court2, lawyer2.getEmployerCourt());
//
//        // Try to assign a lawyer to a different court (should throw an exception)
//        try {
//            court2.addLawyer(lawyer1);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("This lawyer is already assigned to a court.", e.getMessage());
//        }
//    }
//}
