package uvsq.pglp_4_1_;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import uvsq.pglp_4_1_.Personnels.Builder;

public class PersonnelsTest {

	@Test
	public void testConstructeurPersonnels() {
    Personnels p1=new Personnels(new Builder("Maher1","Attouche",LocalDate.now()));
	assert(p1.Prenom.equals("Maher1") && p1.Nom.equals("Attouche") && p1.dateNaissance.equals(LocalDate.now()));
	}
	@Test
	public void testConstructeurCompositePersonnels() {
    Personnels p1=new Personnels(new Builder("Maher1","Attouche",LocalDate.now()));
	assert(p1.Prenom.equals("Maher1") && p1.Nom.equals("Attouche") && p1.dateNaissance.equals(LocalDate.now()));
	}

}
