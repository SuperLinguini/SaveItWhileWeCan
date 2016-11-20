//these variables reperesent the yes or no questions from the user daily input
// 1 = yes, 0 = no
//all names only consider the first element in the name

int beef, chicken, fruits, dairy, pork, processed, bike, car, bus;
int dailyscore =0;
//maximum score = 900

if(car == 0)
dailyscore+= 125;
else
dailyscore+=30;

if(bus ==0)
dailyscore+=50;
else
dailyscore+=30;

if(walk== 1)
dailyscore+= 150;
else
dailyscore+= 30;

if(beef== 0 )
dailyscore+= 125;
else
dailyscore+= 30;

if(chicken == 0)
dailyscore+= 50;
else
dailyscore+=30;

if (dairy ==0 )
dailyscore+= 100;
else
dailyscore+= 30;

if( pork == 0)
dailyscore+= 50;
else
dailyscore+= 30;

if( fruits == 1)
dailyscore+= 150;
else
dailyscore+= 30;

if( processed == 0)
dailyscore += 100;
else
dailyscore +=30;

dailyscore = (dailyscore/900) *100
