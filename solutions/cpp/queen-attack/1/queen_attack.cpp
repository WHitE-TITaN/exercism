#include "queen_attack.h"
#include <utility>
#include <cmath>
#include <stdexcept>

namespace queen_attack {

    std::pair<int,int> w, b;

    chess_board::chess_board(std::pair<int,int> white, std::pair<int,int> black){
            w = white;
            b = black;
        
            if(w.first < 0 ||
               w.first > 7 ||
               w.second < 0 ||
               w.second > 7 ||
               b.first < 0 ||
               b.first > 7 ||
               b.second > 7 ||
               b.second < 0) throw std::domain_error("out of bound");

            if(w == b) throw std::domain_error("same position !");

        }
    
    std::pair<int,int> chess_board::white() const{
        return w;
    }
    std::pair<int,int> chess_board::black() const{
        return b;
    }

    bool chess_board::can_attack() const{

        if(w.first == b.first || w.second == b.second) return true;
        if(std::abs(w.first - b.first) ==
           std::abs(w.second - b.second)) return true;

        return false;
    }


}  // namespace queen_attack
