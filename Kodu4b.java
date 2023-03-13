/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 5
 * Teema: Kahekordsed massiivid ja nende töötlemine. Massiivist kahemõõtmelisse massiivi, mis on ruutmaatriks ja ruutmaatriksi diagonaali elemendid massiivi.
 *
 * Autor: Juhan Pauklin
 *
 **********************************/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Kodu4b {
    /**
     * Esimest järku massiivist elemendid kahemõõtmelisse massiivi, mis on ruutmaatriks.
     * @param a Antud täisarvumassiiv.
     * @return kahemõõtmelisse massiivi, mis on ruutmaatriks, arvestatud ka sellega, kui elemente ei piisa, et ruutmaatriks täita.
     */
    public static int[][] taidaMassiiv(int[] a) {
        int jark = (int) Math.ceil(Math.sqrt(a.length)); // leiame ruutmaatriksi järgu
        int[][] Tulemus = new int[jark][1]; // loome välimise maatriksi
        int orMasI = 0; // originaalmaatriksi (a) indeks
        for (int sisMasI = 0; sisMasI < jark; sisMasI++) { //sisMasI tähendab sisemise massiivi indeks, see tsükkel on n arvu sisemise
            int maxPikkus = Math.min(a.length - orMasI, jark); // leiame kui mitu arvu on võimalik sisemisse massiivi panna
            //kas pikkus on järgu pikkusega või algse massiivi alles jäänud arvude pikkune
            int[] sisemineMassiiv = new int[maxPikkus];

            for (int i = 0; i < maxPikkus; i++, orMasI++) { // lisame arvud sisemisse massiivi
                sisemineMassiiv[i] = a[orMasI];
            }
            Tulemus[sisMasI] = sisemineMassiiv;
        }
        return Tulemus;
    }

    /**
     * Osa koodist on pärit Stackoverflow postitusest 'Loop diagonally through two dimensional array'
     * (https://stackoverflow.com/questions/20420065/loop-diagonally-through-two-dimensional-array)
     * Koodi originaalne autor on user243872 (06/12/2013).
     * Koodi on osaliselt muudetud.
     *
     * Ruutmaatriksi diagonaalide elementide panemine massiivi selles järjekorras nagu nad diagonaalides esinevad.
     * @param b Antud kahemõõtmeline täisarvumassiiv.
     * @return Massiiv, mis sisaldab ruutmaatriksi diagonaalide elemente, selles järjekorras nagu nad diagonaalides esinevad
     */
    public static int[]  diagonaalid(int[][] b) {
        List<Integer> tulemus = new ArrayList<Integer>(); // Loome List'i mugavamaks lisamiseks

        for (int i = b.length - 1; i > 0; i--) { // hakkab alt vasakult nurgast pihta ja liigub üles, kuni peadiagonaalini (kaasa arvatud).
            for (int j = 0, x = i; x <= b.length - 1; j++, x++) { // diagonaali esimene el alati kohal (i;0), teine (olemasolu puhul) (i+1; 1) jne, nii et asendame sobivamate muutujatega
                try { // try {} catch {} kasutamine on veits nagu raudkangi kasutamine, et ust lahti teha, aga ta töötab :)
                    tulemus.add(b[x][j]);
                } catch (Exception e) { // kui sellisel indeksil elementi pole...
                    break; // siis lõpetab tsükli
                }
            }
        }
        for (int i = 0; i <= b.length - 1; i++) { // hakkab üleval vasakult paremale poole liikuma
            for (int j = 0, y = i; y <= b.length - 1; j++, y++) { // diagonaali esimene el alati kohal (0;i), teine (1; i+1) jne
                try {
                    tulemus.add(b[j][y]);
                } catch (Exception e) {
                    break;
                }
            }
        }
        int[] tulemusMassiiv = new int[tulemus.size()];
        for (int x = 0; x < tulemus.size(); x++) { // teisendame ArrayListi massiiviks.
            tulemusMassiiv[x] = tulemus.get(x);
        }
        return tulemusMassiiv;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[][] b = taidaMassiiv(a);
        System.out.println("Ruutmaatriks ");
        for (int[] väljund: b) System.out.println(Arrays.toString(väljund));
        int[] c = diagonaalid(b);
        System.out.println("Diagonaalide elemendid " + Arrays.toString(c));
        System.out.println(" ");

        int[] d = {1, 2, 3, 4, 5, 6, 7};
        int[][] e = taidaMassiiv(d);
        System.out.println("Ruutmaatriks ");
        for (int[] väljund: e) System.out.println(Arrays.toString(väljund));
        int[] f = diagonaalid(e);
        System.out.println("Diagonaalide elemendid " + Arrays.toString(f));
        System.out.println(" ");



    }

}
