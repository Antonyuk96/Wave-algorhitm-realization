public class VolNa2 {
 
    public static void main(String[] args) {
//Вводим переменные
    int x = 0;
    int y = 0;
    int i = 0;
    int z = 0;
    int k = 0;
    int j = 0;
    int Ni = 0;
    int Nk = 256;
    int n = 10;

    //Матрица лабиринта
    int lab[][] = { 
    {254, 254, 254, 254, 254, 254, 254, 254, 254, 254},
    {253, 254, 254, 254, 254, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 254, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 255, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 254, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 254,  0,  254, 254, 254, 254},
    {254, 254, 254, 255, 254, 254, 254, 254, 254, 254},
    {254, 254, 254, 255, 255, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 254, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 254, 254, 254, 254, 254, 254},
    {254, 254, 254, 254, 254, 254, 254, 254, 254, 254}};

    //Инициализация матрицы пути
    int kurs[][] = new int [n][n];
    for(i = 0; i < n; i++){
    for(j = 0; j < n; j++){
    kurs[i][j] = 122;
    }
    }

    //Три цикла для прохождения матрицы лабиринта
    label : for (int l = 0; l < 256; l++){
    for (i = 0; i < n; i++){ 
    for (j = 0; j < n; j++){

    //Условия распространенния волны
    if (lab[i][j] == Ni && i > 0 && i < n && j > 0 && j < n-1){


    if(lab[i][j+1] == 254){
    lab[i][j+1] = Ni+1;
    }
    if(lab[i][j+1]== 253){
    z = i;
    k = j+1;
    break label;
    }

    if(lab[i+1][j] == 254){
    lab[i+1][j] = Ni+1;
    }
    if(lab[i+1][j]== 253){
    z = i+1;
    k = j;
    break label;

    }

    if(lab[i][j-1] == 254){
    lab[i][j-1] = Ni+1;
    }
    if(lab[i][j-1] == 253){
    z = i;
    k = j-1;
    break label;

    }

    if(lab[i-1][j] == 254){
    lab[i-1][j] = Ni+1;
    }
    if(lab[i-1][j] == 253){
    z = i-1;
    k = j;
    break label;

    }


    }

    }
    }
    //Коэффициент распространения волны
    Ni++;
    }
    //Вывод волны
    for (i = 0; i < n; i++){
    for (j = 0; j < n; j++){
    System.out.printf("%4d", lab[i][j]);
    }
    System.out.println();
    }
    lab[z][k] = Ni+1;
    Ni++;
    
    //Печать
    for (i = 0; i < n; i++){
    for (j = 0; j < n; j++){
    if (lab[z][k]>=lab[z+1][k]){
    kurs[z][k] = Ni;
    z = z+1; 
    Ni--; 
    }
    
    if (lab[z][k]>=lab[z-1][k]){
    kurs[z][k] = Ni;
    z = z-1;
    Ni--; 
    }
    
    if (lab[z][k]>=lab[z][k+1]){
    kurs[z][k] = Ni;
    k = k+1;
    Ni--; 
    }
    
    if (lab[z][k]>=lab[z][k-1]){
    kurs[z][k] = Ni;
    k = k - 1;
    Ni--; 
    }
    kurs[z][k] = Ni;
    }
    }
    //Нахождение самого короткого пути
    for (i = 0; i < n; i++){
    for (j = 0; j < n; j++){
    System.out.printf("%4d", kurs[i][j]);
    }
    System.out.println();
    }
    }
    }
