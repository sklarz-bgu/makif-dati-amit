public class Automaton {
    public static int width = 40,height = 40;
    public static Element[][] left = new Element[height][width];
    public static Element[][] right = new Element[height][width];
    public static int numOfCities = 0;
    public static int numOfDays = 0;


    //temperature variables
    public static int sumDailyTemp;
    public static int dailyTemp;
    public static int minDailyTemp = 100000;
    public static int maxDailyTemp = 0;
    public static int avgYearlyTemp = 0;
    public static int sumYearlyTemp = 0;
    public static float[] dailyTemps = new float[4000];
    public static float tempVariance;
    public static float tempStdDev = 0;

    //pollution variables
    public static int sumPollution;
    public static float dailyPollution;
    public static float minDailyPol = 100000;
    public static float maxDailyPol = 0;
    public static float avgYearlyPol = 0;
    public static float sumYearlyPol = 0;
    public static float[] dailyPollutions = new float[4000];
    public static float polVariance;
    public static float polStdDev = 0;

    //wind variables
    public static int sumWind;
    public static float dailyWind;
    public static float minWind = 100000;
    public static float maxWind = 0;
    public static float avgYearlyWind = 0;
    public static float sumYearlyWind = 0;
    public static float[] dailyWinds = new float[4000];
    public static float windVariance;
    public static float windStdDev = 0;

    //graph things
    public static int[] graphDaysX = new int[4000];
    public static int[] graphTemps = new int[4000];
    public static int[] graphPols = new int[4000];
    public static int[] graphWinds = new int[4000];

    public void init(){
        for (int i = 0; i < height; i++){
            for (int j= 0; j < width; j++){
                left[i][j] = new Element(1);
            }
        }

        for (int j = 0; j < width; j ++) {
            //northern iceberg
            int z1 = j + 4;
            if(z1 < 38){
                left[0][z1] = new Element(2);
            }
            int z = j + 2;
            if(z < 31){
                left[1][z] = new Element(2);
            }
            int w = j + 4;
            if(w < 29){
                left[2][w] = new Element(2);
            }
            int x = j + 1;
            if(x < 27) {
                left[3][x] = new Element(2);
            }

            //southern sea
            left[height - 1][j] = new Element(0);
            left[height - 2][j] = new Element(0);
            left[height - 3][j] = new Element(0);
            int x2 = j + 4;
            if(x2 < width) {
                left[height - 4][x2] = new Element(0);
            }
            int x3 = j + 8;
            if(x3 < width - 8) {
                left[height -5][x3] = new Element(0);
            }

            //city
            int x6 = j  +10;
            if(x6 < 13) {
                left[height -6][x6] = new Element(4);
            }
            int x7 = j + 8;
            if(x7 < 24) {
                left[height - 7][x7] =new Element(4);
            }
            int x8 = j + 8;
            if(x8 < 25) {
                left[height -8][x8] = new Element(4);
            }
            int x9 = j + 8;
            if(x9 < 26) {
                left[height - 9][x9] = new Element(4);
            }
            int x10 = j + 9;
            if(x10 < 25) {
                left[height - 10][x10] = new Element(4);
            }

            //forest
            Element e;
            int f5 = j  +5;
            if(f5 < width - 5) {
                left[5][f5] = e = new Element(3);
                if(j < 15){
                    e.height = 60;
                }
            }
            int f6 = j + 2;
            if(f6< width - 3) {
                left[6][f6] =  e = new Element(3);
                if(j < 15){
                    e.height = 60;
                }

            }
            int f7 = j + 2;
            if(f7 < width - 2) {
                left[7][f7] = e =  new Element(3);
                if(j < 15){
                    e.height = 60;
                }

            }
            int f8 = j + 2;
            if(f8 < width - 2) {
                left[8][f8] = e = new Element(3);
                if(j < 15){
                    e.height = 60;
                }
            }
            int f9 = j + 3;
            if(f9 < width - 2) {
                left[9][f9] = e = new Element(3);
                if(j < 15){
                    e.height = 60;
                }
            }
            int f10 = j + 3;
            if(f10 < width - 2) {
                left[10][f10] =e = new Element(3);
                if(j < 15){
                    e.height = 60;
                }
            }
            int f11 = j + 7;
            if(f11 < width - 3) {
                left[11][f11] =e= new Element(3);
                if(j < 15){
                    e.height = 60;
                }
            }
            int f12 = j + 9;
            if(f12 < width - 10) {
                left[12][f12] =e= new Element(3);
                if(j < 15){
                    e.height = 60;
                }
            }




        }
        //wind
        for (int i =0; i < height; i ++) {
            for (int j = 0; j < width;j ++) {
                if(((i % 4 == 0 || i % 4 == 1) && (j % 4 == 0 || j % 4 == 1)) && j > 2 && i < 20)  {
                    left[i][j].windy = 4;
                }
            }
        }

        for (int i = 0; i < height; i++){
            for (int j= 0; j < width; j++){
                right[i][j] = left[i][j];
            }
        }
    }
    /* type
    0 = sea
    1 = land
    2 = iceberg
    3 = forest
    4 = city
    * */

    public void rules(){
        for (int i = 0; i < height; i++){
            for (int j= 0; j < width; j++){
                right[i][j] = new Element(left[i][j]);
                int wind = 0;
                Element source;
                Element current = left[i][j];
                Element target = right[i][j];
                Element north = left[i - 1 < 0 ? height - 1 : i - 1][j];
                Element east = left[i][j + 1 == width ? 0 : j + 1];
                Element west = left[i][j - 1 < 0 ? width - 1 : j - 1];
                Element south = left[i + 1 == height ? 0 : i + 1][j];
                Element northEast = left[i - 1 < 0 ? height - 1 : i - 1][j + 1 == width ? 0 : j + 1];
                Element northWest = left[i - 1 < 0 ? height - 1 : i - 1][j - 1 < 0 ? width - 1: j - 1];
                Element southEast = left[i + 1 == height ? 0 : i + 1][j + 1 == width ? 0 : j + 1];
                Element southWest = left[i + 1 == height ? 0 : i + 1][j - 1 < 0 ? width - 1: j - 1];
                //windDirection 1 south; 2 west ;3 east; 4 north;

                if((wind = (source = north).windy) == 1 || (wind = (source =  west).windy) == 3 //incoming wind
                        ||  (wind = (source = east).windy) == 2 || (wind = (source = south).windy) == 4){

                    target.pollution += source.pollution ;
                    if (target.pollution > 5){
                        target.pollution = 5;
                    }
                    if(source.cloudy){
                        target.cloudy = true;
                    }
                    target.windy = wind;
                } else if(current.windy != 0){
                    target.cloudy = false;
                    target.pollution = 0;
                }

                if(current.windy != 0 && north.windy != 1 && west.windy != 3 && east.windy != 2 && south.windy != 4){
                    target.windy = 0;
                }

                if(current.type == 4 && current.pollution < 5){
                    target.pollution  += 1;

                }
                if(current.pollution > 0){
                    target.temper += current.pollution;
                    if(target.temper > 70 ) {
                        target.temper = 70;
                    }
                }
                if(current.temper > 30){
                    target.temper --;
                }
                if(current.temper < 20) {
                    target.temper ++;
                }
                if(current.type == 2) {
                    if (current.temper > 0){
                        target.temper -= 2;
                    }
                    if (current.temper > 40){
                        target.type = 0;
                    }
                }
                if(current.type == 0){
                    if(north.type == 0 && south.type == 0 && west.type == 0 && east.type == 0
                    && northWest.type == 0 && northEast.type == 0 && southWest.type == 0 && southEast.type == 0){
                        target.cloudy = true;
                    }
                }
                if(current.type == 3) {
                    if (current.temper > 50){
                        target.type = 1;
                    }
                }
                if(current.height > 30){
                    target.raining = current.cloudy;
                    if(current.cloudy) {
                        target.pollution = 0;
                    }
                }
                //statistics
                sumDailyTemp += current.temper;
                sumPollution += current.pollution;
                if(current.type == 4){
                    numOfCities ++;
                }
                if(current.windy != 0){
                    sumWind++;
                }
            }
        }
        Element[][] temp;
        temp = right;
        right = left;
        left = temp;

        numOfDays++;
        ////////////////////////////////////////////////////////////////////////////////
        //temperature
        dailyTemp = sumDailyTemp / (height * width);
        dailyTemps[numOfDays] = dailyTemp;
        if(dailyTemp > maxDailyTemp) {
            maxDailyTemp = dailyTemp;
        }
        if(dailyTemp < minDailyTemp){
            minDailyTemp = dailyTemp;
        }


        sumYearlyTemp += dailyTemp;
        avgYearlyTemp = sumYearlyTemp / numOfDays;

        tempVariance = calcSumOfDistances(avgYearlyTemp,dailyTemps) / (numOfDays == 1 ? 1 : numOfDays - 1 );
        tempStdDev = (float)Math.sqrt(tempVariance);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //pollution
        dailyPollution = (float)sumPollution / (height * width);
        dailyPollutions[numOfDays] = dailyPollution;
        if(dailyPollution > maxDailyPol) {
            maxDailyPol = dailyPollution;
        }
        if(dailyPollution < minDailyPol){
            minDailyPol = dailyPollution;
        }
        sumYearlyPol += dailyPollution;
        avgYearlyPol =  sumYearlyPol / numOfDays;

        polVariance = calcSumOfDistances(avgYearlyPol,dailyPollutions) / (numOfDays == 1 ? 1 : numOfDays - 1 );
        polStdDev = (float)Math.sqrt(polVariance);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //wind
        dailyWind = (float)(sumWind) /  (height * width);
        dailyWinds[numOfDays] = dailyWind;
        if(dailyWind > maxWind) {
            maxWind = dailyWind;
        }
        if(dailyWind < minWind){
            minWind = dailyWind;
        }
        sumYearlyWind += dailyWind;
        avgYearlyWind =  sumYearlyWind / numOfDays;

        windVariance = calcSumOfDistances(avgYearlyWind,dailyWinds) / (numOfDays == 1 ? 1 : numOfDays - 1 );
        windStdDev = (float)Math.sqrt(windVariance);

        ///////////////////////////////////////////////////////////////////////////////////////////

        //graph
        graphDaysX[numOfDays] = numOfDays*2 + Painter.xOffset;
        graphTemps[numOfDays] = Painter.yOffset - (int)(((dailyTemp - avgYearlyTemp) * 1000) / tempStdDev );
        graphPols[numOfDays] = Painter.yOffset - (int)(((dailyPollution - avgYearlyPol) * 500) / polStdDev );
        graphWinds[numOfDays] = Painter.yOffset - (int)(((dailyWind - avgYearlyWind) * 500) / windStdDev );

        //prints

        //resets
        sumDailyTemp = 0;
        numOfCities = 0;
        sumWind = 0;
        dailyPollution = 0;
        sumPollution = 0;

    }

    public float calcSumOfDistances(float avg , float[] dataPoints){
        float res = 0;
        for ( float x : dataPoints) {
            res += Math.pow(x - avg,2);
        }
        return res;
    }

}
