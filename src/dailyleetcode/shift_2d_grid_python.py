from typing import List
from math import gcd
# An attempt to modify the arry in place

def shiftGrid(grid: List[List[int]], k: int) -> List[List[int]]:
    maxOfI = len(grid)
    maxOfJ = len(grid[0])
    total_elements = maxOfI * maxOfJ
    number_of_cycles = gcd(total_elements, k)
    for cycle in range(number_of_cycles):
        jth_position = (0 + cycle) % maxOfJ
        ith_position =  (0 + cycle//maxOfJ)%maxOfI
        current_element = grid[ith_position][jth_position]
        temporary_store = 0
        start_idx = [ith_position,jth_position]
        infin_loop = 0
        while True:
            offset = jth_position + k
            jth_position = offset%maxOfJ
            ith_position = ((offset//maxOfJ)+ith_position)%maxOfI
            print(f"i,j : {ith_position}:{jth_position}")
            temporary_store = grid[ith_position][jth_position]
            grid[ith_position][jth_position] = current_element
            current_element = temporary_store
            infin_loop+=1
            if [ith_position, jth_position] == start_idx:
                print("THis condition holds true")
                break
    return grid

grid = [[1,2,3],[4,5,6],[7,8,9]]
k = 1
print(shiftGrid(grid,k))