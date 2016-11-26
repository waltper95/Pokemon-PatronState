
package pe.edu.ulima.ef.pokemonsoft;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Blastoise;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Bulbasaur;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Charizard;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Charmeleon;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Ivysaur;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Squirtle;
import pe.edu.ulima.ef.pokemonsoft.pokemon.Wartortle;



public class PokemonTest {
    
    public void PokemonTest(){
    }
    
    @Test
    public void testBulbasaurToIvysaur(){
        Pokemon pokemon = new Pokemon();
        pokemon.setEspecie(new Bulbasaur(pokemon));
        pokemon.setNivel(16);
        pokemon.getEspecie().evolucionar();
        assertTrue("Error, no evoluciiona a Ivysaur", pokemon.getEspecie() instanceof Ivysaur);
    }
    
    @Test
    public void testCharmeleonToCharizard(){
        
        Pokemon pokemon = new Pokemon();
        pokemon.setEspecie(new Charmeleon(pokemon));
        pokemon.setNivel(36);
        pokemon.getEspecie().evolucionar();
        assertTrue("Error, no evoluciiona a Charizard", pokemon.getEspecie() instanceof Charizard);
    
    }
    
    @Test
    public void testSquirtleToWartortle(){
        Pokemon pokemon = new Pokemon();
        pokemon.setEspecie(new Squirtle(pokemon));
        pokemon.setNivel(16);
        pokemon.getEspecie().evolucionar();
        assertTrue("Error, no evoluciiona a Wartortle", pokemon.getEspecie() instanceof Wartortle);
    }
    
    @Test
    public void testPeleaCharmeleonWartortleGanaWartortle(){
        CalculadorPeleas calculador = mock(CalculadorPeleas.class);
        
        Pokemon pok1 = new Pokemon();
        pok1.setEspecie(new Charmeleon(pok1));
        pok1.setNivel(35);
        
        Pokemon pok2 = new Pokemon();
        pok2.setEspecie(new Wartortle(pok2));
        pok2.setNivel(35);
        
        when(calculador.luchar(pok1, pok2)).thenReturn(2);
        
        PokemonBattle pb = new PokemonBattle(calculador);
        pb.luchar(pok1, pok2);
        
        
        assertTrue("Error. no gana el pokemon correspondiente", 
                pok2.getEspecie() instanceof Blastoise && pok1.getEspecie() instanceof Charmeleon);
        
    }
    
    @Test
    public void testPeleaBulbasaurSquirtleGanaBulbasaur(){
        CalculadorPeleas calculador = mock(CalculadorPeleas.class);
        
        Pokemon pok1 = new Pokemon();
        pok1.setEspecie(new Bulbasaur(pok1));
        pok1.setNivel(15);
        
        Pokemon pok2 = new Pokemon();
        pok2.setEspecie(new Squirtle(pok2));
        pok2.setNivel(15);
        
        when(calculador.luchar(pok1, pok2)).thenReturn(1);
        
        PokemonBattle pb = new PokemonBattle(calculador);
        pb.luchar(pok1, pok2);
        
        
        assertTrue("Error. no gana el pokemon correspondiente", 
                pok2.getEspecie() instanceof Ivysaur && pok1.getEspecie() instanceof Squirtle);
        
        
    }
    
    
}
