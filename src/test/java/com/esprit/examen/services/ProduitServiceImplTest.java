package com.esprit.examen.services;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.This;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.ProduitServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = Produit.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class ProduitServiceImplTest {
    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitServiceService;
    Produit p = new Produit();


    Produit produit = new Produit(14L, 1998L);

    List<Produit> list = new ArrayList<Produit>() {

        {
            add(new Produit());
            add(new Produit());

        }
    };

    @Test
    public void getAllProduitTest() {
        List<Produit> Produitlist = new ArrayList<Produit>() {

            {
                add(new Produit(3L, null, 1998, null, null, null, null, null, null));
                add(new Produit(5L, null, 16, null, null, null, null, null, null));
                add(new Produit(8L, null, 112, null, null, null, null, null, null));
            }
        };


        Mockito.when(produitServiceService.retrieveAllProduits()).thenReturn(Produitlist);
        List<Produit> factureList = produitServiceService.retrieveAllProduits();
        System.out.println(" good job <3 ");
    }


    @Test
    void test_addProduit() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        //mock
        Mockito.when(produitRepository.save(any())).thenReturn(p);

        //assert
        assertEquals(1L, p.getIdProduit());
    }

    @Test
    public void delete() {

        Produit p = new Produit();
        p.setIdProduit(Long.valueOf(100));
        produitServiceService.addProduit(p);
        produitServiceService.deleteProduit(p.getIdProduit());

    }

    @Test
    public void updateProduit() {
        Mockito.when(produitRepository.save(p)).thenReturn(p);
        Produit p1 = produitServiceService.updateProduit(p);
        Assertions.assertEquals(p, p1);


    }
}
