package uvsq.pglp_4_1_;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import uvsq.pglp_4_1_.Personnels.Builder;

public class PersonnelsTest {

	@Test
	public void testConstructeurPersonnels() {
    Personnels p1=new Personnels.Builder("Maher1", "Attouche", LocalDate.now()).build();
	assert(p1.Prenom.equals("Maher1") && p1.Nom.equals("Attouche") && p1.dateNaissance.equals(LocalDate.now()));
	}
	
	@Test
	public void testConstructeurPersonnelsComplet()
	{
	    Personnels p1=new Personnels.Builder("Maher1", "Attouche", LocalDate.now()).AddTel(555).build();
		assert(p1.Prenom.equals("Maher1") && p1.Nom.equals("Attouche") && p1.dateNaissance.equals(LocalDate.now()) && p1.numerosDeTel.size()==1 && p1.numerosDeTel.get(0)==555);

	}
	
	@Test
	public void testConstructeurCompositePersonnels() {
    	CompositePersonnels cp3=new CompositePersonnels(3);
		assert(cp3.id==3);
	}
	
	@Test
	public void testAddComposite() {
    	CompositePersonnels cp3=new CompositePersonnels(3);
	    Personnels p1=new Personnels.Builder("Maher1", "Attouche", LocalDate.now()).AddTel(555).build();
    	cp3.add(p1);
    	assert(cp3.personnes.size()==1 && cp3.personnes.get(0).equals(p1));
	}

}
