#include <utility>
#pragma once
namespace queen_attack {

    class chess_board{
        
        public:
        chess_board(std::pair<int,int>, std::pair<int,int>);

        std::pair<int,int> white() const, black() const;
        bool can_attack() const;
    };

}  // namespace queen_attack
