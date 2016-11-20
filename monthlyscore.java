int monthlyscore=0, household, flights, trash, recycle;
double energy, water, donation1, donation2, donation3;

//max score is 450
energy= energy/household;
water= water/ household;
trash= trash/ household;
recycle= recycle/ household;
int donation = donation1+ donation2+ donation3;

if(energy>=1300)
monthlyscore +=0;
else if(energy <1300 && energy > 1150)
monthlyscore +=1;
else if( energy <= 1150 && energy > 1000)
monthlyscore += 2;
else if(energy <= 1000 && energy > 850 )
monthlyscore += 3;
else if(energy <=850 && energy > 650)
monthlyscore += 4;
else
monthlyscore +=5;

if(water> 2200)
monthlyscore +=0;
else if(water <= 2200 && water > 2000)
monthlyscore +=1;
else if( water <= 2000 && water > 1700)
monthlyscore += 2;
else if(energy <= 1700 && water > 1500 )
monthlyscore += 3;
else if(water <= 1500 && water > 1300)
monthlyscore += 4;
else
monthlyscore +=5;

if(trash> 6)
monthlyscore +=0;
else if(trash == 5)
monthlyscore +=1;
else if( trash==4 )
monthlyscore += 2;
else if(trash ==3 )
monthlyscore += 3;
else if(trash ==2 )
monthlyscore += 4;
else
monthlyscore +=5;

if(recycle==0)
monthlyscore +=0;
else if(recycle == 1)
monthlyscore +=3;
else if( recycle== 2)
monthlyscore += 4;
else
monthlyscore += 5;

if(flights >= 3)
monthlyscore +=0;
else if(flights == 2)
monthlyscore += 2;
else if(flights ==1 )
monthlyscore += 3;
else if(flights==0 )
monthlyscore += 5;

if(donation >= 15)
monthlyscore += 6;
else if(donation > 15 && donation >=10)
monthlyscore +=5;
else if(donation > 10 && donation >= 5)
monthlyscore +=4;
else
monthlyscore +=3;

monthlyscore= monthlyscore/30;

if(monthlyscore > 100)
monthlyscore= monthlyscore - (monthlyscore - 100);
