function crush(stones) {
  let output = -1;
  stones.sort((a, b) => a - b);

  while (stones.length > 1) {
    let stone1 = stones.pop();
    let stone2 = stones.pop();
    let diff = stone1 - stone2;
    stones.push(diff);
    stones.sort((a, b) => a - b);

    if (stones.length == 1) {
      output = stones[0];
    }
  }
  console.log(output);
  return output;
}

console.log(2, 4, 5);
crush([2, 4, 5]);
console.log(1, 2, 3, 6, 7, 7);
crush([1, 2, 3, 6, 7, 7]);
