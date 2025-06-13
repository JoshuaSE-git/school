cmake_minimum_required(VERSION 3.10)
project(ApexLab)

set(CMAKE_CXX_STANDARD 14)

add_executable(ApexLab testbench.cpp apex_code.cpp apex_code.h)
