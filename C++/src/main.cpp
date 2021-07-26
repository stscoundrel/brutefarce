#include <iostream>
using namespace std;
  
int main(int argc, char** argv) {
    string password = argv[1];
    unsigned short int min_length = atoi(argv[2]); 
    unsigned short int max_length = atoi(argv[3]);
    
    printf("%s \n", password.c_str()); 
    printf("%d \n", min_length); 
    printf("%d \n", max_length); 

    return 0;
}