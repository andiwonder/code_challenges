function MinUniqArrSum(input) {
  input.sort((a, b) => a - b);
  for (let i = 0; i < input.length; i++) {
    if (i != 0) {
      while (input[i - 1] >= input[i]) {
        input[i] += 1;
      }
    }
  }

  console.log(input);

  let output = input.reduce((acc, el) => {
    return acc + el;
  }, 0);
  console.log('sum is ' + output);
  return output;
}

console.log(1, 2, 2);
MinUniqArrSum([1, 2, 2]);
console.log(3, 2, 1, 2, 7);
MinUniqArrSum([3, 2, 1, 2, 7]);
console.log(3, 2, 1, 3, 7, 3, 8);
MinUniqArrSum([3, 2, 1, 3, 7, 3, 8]);
