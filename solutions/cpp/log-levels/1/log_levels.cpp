#include <string>

namespace log_line {

std::string message(std::string line) {
    int end = line.find("]");
    return line.substr(end + 3);
}

std::string log_level(std::string line) {
    int start = line.find("["), end = line.find("]");
    return line.substr(start + 1, (end - start) - 1);
}

std::string reformat(std::string line) {
    int start = line.find("["), end = line.find("]");
    std::string error_code = line.substr(start + 1, (end - start) - 1),
        newMessage = line.substr(end + 3);

    std::string mainString = newMessage + " (" + error_code + ")";
    return mainString;
}
}  // namespace log_line
