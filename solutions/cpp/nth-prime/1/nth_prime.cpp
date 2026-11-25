#include "nth_prime.h"
#include <iostream>
#include <cmath>

namespace nth_prime {
    int count = 1, prime = 2;

    bool check_prime(int number){
        //std::cout<<int(std::sqrt(number))<<"\n";
        for(int i = 2; i <= int(std::sqrt(number)); i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
    
    int nth(int position){
        if(position <= 0) throw std::domain_error("out_of_range");

        while(count < position){
            prime++;
            if(check_prime(prime)){
                count++;
            }
        }
        std::cout<<prime;
        return prime;
    }

}  // namespace nth_prime
