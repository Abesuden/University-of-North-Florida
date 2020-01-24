// Project 2 - COP2220
 /*

  Written By:     Alexander Besuden
  Date:           5.30.18

 *   This program is used to create a bill of sale for a company called, "Russian Black Market inc." The price of goods is incorperated into individual totals for each item and then used to calculate the subtotal, tax, and grand total. This allows the user to know exactly how many currency or Bitcoins to use when completing payment.

 *   The total prices for each individual product is calculated first. These numbers are stored in a variable starting with tot___. These are then added together and applied some multiplication for tax. calcTax multiplies the tax rate to find the amount of tax. subTot just keeps the addition and displays the total without tax applied. tot multiplies one times tax rate, times the added total which gives grand total.

 */


#include <stdio.h>

int main(void) {

// initiation step
  int qunt1_tv, qunt2_vcr, qunt3_remoteContr, qunt4_cdPlayer, qunt5_enrichedUranium;
  float price1_tv = 400.00, /*qunt1_tv,*/ price2_vcr = 220.00, /*qunt2_vcr,*/ price3_remoteController = 35.20, /*qunt3_remoteContr,*/ price4_cdPlayer = 300.00, /*qunt4_cdPlayer,*/ price5_enrichedUranium = 150.00, /*qunt5_enrichedUranium,*/ subtotal, tax = 1.0825, calcTax, subTot, tot, totTv, totVcr, totRemoteControl, totCDplayer, totEnrichedUranium;
 //    float price1_tv = 400.00, qunt1_tv, price2_vcr = 220.00, qunt2_vcr, price3_remoteController = 35.20, qunt3_remoteContr, price4_cdPlayer = 300.00, qunt4_cdPlayer, price5_enrichedUranium = 150.00, qunt5_enrichedUranium, subtotal, tax = 1.825, calcTax, subTot, tot, totTv, totVcr, totRemoteControl, totCDplayer, totEnrichedUranium;
// print welcome
  printf("\n\n\n   --Welcome to the Russian Emporium--\n\t Hours:\t8-5 US daily\n\n^^^Contact Sergei for our WEAPONS department^^^\n\n\n");

// print prices
  printf("Today, we have to offer...\n\nGoods:\t\t\tPrice:\n------\t\t\t------\nTV\t\t\t%.2f\nVCR\t\t\t%.2f\nRemot Control\t\t %.2f\nCD Player\t\t%.2f\nEnriched Uranium\t%.2f\n\n", price1_tv, price2_vcr, price3_remoteController, price4_cdPlayer, price5_enrichedUranium);

// promt user
  printf("How many would you like:\nTV\t\t\t--> ");
    scanf("%d", &qunt1_tv);
  printf("VCR\t\t\t--> ");
    scanf("%d", &qunt2_vcr);
  printf("Remote Control\t\t--> ");
    scanf("%d", &qunt3_remoteContr);
  printf("CD Player\t\t--> ");
    scanf("%d", &qunt4_cdPlayer);
  printf("Enriched Uranium\t--> ");
    scanf("%d", &qunt5_enrichedUranium);

// math
  totTv               =  (float)(price1_tv*qunt1_tv);
  totVcr              =  (float)(price2_vcr*qunt2_vcr);
  totRemoteControl    =  (float)(price3_remoteController*qunt3_remoteContr);
  totCDplayer         =  (float)(price4_cdPlayer*qunt4_cdPlayer);
  totEnrichedUranium  =  (float)(price5_enrichedUranium*qunt5_enrichedUranium);

  // calcTax = (tax-1) * ((float)(price1_tv*qunt1_tv) + (float)(price2_vcr*qunt2_vcr) + (float)(price3_remoteController*qunt3_remoteContr) + (float)(price4_cdPlayer*qunt4_cdPlayer) + (float)(price5_enrichedUranium*qunt5_enrichedUranium));

  calcTax = (tax-1) * ((totTv)+(totVcr)+(totRemoteControl)+(totCDplayer)+(totEnrichedUranium));

  // subTot = ((float)(price1_tv*qunt1_tv) + (float)(price2_vcr*qunt2_vcr) + (float)(price3_remoteController*qunt3_remoteContr) + (float)(price4_cdPlayer*qunt4_cdPlayer) + (float)(price5_enrichedUranium*qunt5_enrichedUranium));

   subTot = (totTv)+(totVcr)+(totRemoteControl)+(totCDplayer)+(totEnrichedUranium);

  // tot = tax * ((float)(price1_tv*qunt1_tv) + (float)(price2_vcr*qunt2_vcr) + (float)(price3_remoteController*qunt3_remoteContr) + (float)(price4_cdPlayer*qunt4_cdPlayer) + (float)(price5_enrichedUranium*qunt5_enrichedUranium));

  tot = tax * ((totTv)+(totVcr)+(totRemoteControl)+(totCDplayer)+(totEnrichedUranium));

// print bill
  printf("\n\n\n\nHere is the bill with how much you owe Mother Russia...\n\nQTY\tDESCRIPTION\t  UNIT PRICE\tTOTAL PRICE\n---\t-----------\t  ----------\t-----------\n");
  printf("%.1d\tTV\t\t  %10.2f\t%11.2f\n%.1d\tVCR\t\t  %10.2f\t%11.2f\n%.1d\tRemote Control\t  %10.2f\t%11.2f\n%.1d\tCD Player\t  %10.2f\t%11.2f\n%.1d\tEnriched Uranium  %10.2f\t%11.2f\n", qunt1_tv, price1_tv, totTv, qunt2_vcr, price2_vcr, totVcr, qunt3_remoteContr, price3_remoteController, totRemoteControl,  qunt4_cdPlayer, price4_cdPlayer, totCDplayer, qunt5_enrichedUranium, price5_enrichedUranium, totEnrichedUranium);
  printf("\t\t\t\t\t-----------\n\t\t\tSUBTOTAL:\t%11.2f\n\t\t\tTAX:\t\t%11.2f\n\t\t\tTOTAL:\t\t%11.2f\n", subTot, calcTax, tot);
  printf("\n\n");
// ending comment
  printf("WE NOW TAKE BITCOINS!!");
  printf("\n\n");

  return 0;
}