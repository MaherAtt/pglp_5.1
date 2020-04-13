package uvsq.pglp_4_1_;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import org.junit.Test;

import uvsq.pglp_4_1_.Personnels.Builder;

public class PersonnelsTest {

	@Test
	public void testConstructeurPersonnels() {
    Personnels p1=new Personnels.Builder("Maher1", "Attouche", LocalDate.now()).build();
	assert(p1.Nom.equals("Maher1") && p1.Prenom.equals("Attouche") && p1.dateNaissance.equals(LocalDate.now()));
	}
	
	@Test
	public void testConstructeurPersonnelsBuilderOptionnel()
	{
	    Personnels p1=new Personnels.Builder("Maher1", "Attouche", LocalDate.now()).AddTel(555).build();
		assert(p1.Nom.equals("Maher1") && p1.Prenom.equals("Attouche") && p1.dateNaissance.equals(LocalDate.now())  );

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
	
	@Test
	public void testAddPersonnel() {
    	CompositePersonnels cp3=new CompositePersonnels(3);
    	CompositePersonnels cp2=new CompositePersonnels(1);
    	cp3.add(cp2);
    	assert(cp3.personnes.size()==1 && cp3.personnes.get(0).equals(cp2));
    	
	}
	
	@Test
	public void testAffichageGroupHierarchiqueIterator()
	{
		Personnels p1=new Personnels(new Builder("Maher1","Attouche",LocalDate.now()));
    	Personnels p4=new Personnels(new Builder("Maher4","Attouche",LocalDate.now()));
    	Personnels p5=new Personnels(new Builder("Maher5","Attouche",LocalDate.now()));

    	CompositePersonnels cp3=new CompositePersonnels(3);
    	CompositePersonnels cp2=new CompositePersonnels(2);
    	
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
    	
    	cp2.add(p4);
    	cp2.add(p5);
    	cp3.add(p1);
    	cp3.add(cp2);
    	
    	//cp3.print();
    	
    	AffichageGroup affgrp= new AffichageGroup(cp3);
    	
    	for(Iterator i=affgrp.iterator();i.hasNext();)
    	{
    	    ((GroupPersonnels) i.next()).print();
    	}
    	
		assertEquals("3\n" + 
				"Nom:Maher1\n" + 
				"2\n" + 
				"Nom:Maher4\n" + 
				"Nom:Maher5\n" + 
				"Nom:Maher1\n" + 
				"2\n" + 
				"Nom:Maher4\n" + 
				"Nom:Maher5\n" + 
				"Nom:Maher4\n" + 
				"Nom:Maher5\n", outContent.toString());
    	
	}
	
	@Test
	public void testSerialize() {
    	Personnels p1=new Personnels(new Builder("Maher1","Attouche",LocalDate.now()));
		p1.serialize("employee.txt");
    	Personnels ph=null;
    	ph=Personnels.deserialize("employee.txt");
    	assert(ph.Nom.equals("Maher1") && ph.Prenom.equals("Attouche") && ph.dateNaissance.equals(LocalDate.now()));
    	
	}

}
