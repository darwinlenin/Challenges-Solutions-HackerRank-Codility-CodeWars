/** Minimun Array SubElements **/
//a Array Of Elements
//k length of minimun subArray Elements
function getMaxSubArray(a, k) {
  let minIndex = 0;
  let maxIndex = -1;
  for (let j = 0; j < a.length; j++) {
    if (a[j] > k) {
      continue;
    }

    let sum = a[j];
    for (let index = j + 1; index < a.length; index++) {
      if (sum + a[index] > k) {
        if ((index - 1) - j > maxIndex - minIndex) {
          maxIndex = index - 1;
          minIndex = j;
        }
        break;
      }
      sum += a[index];
    }
  }

  if (maxIndex - minIndex < 0) {
    return;
  }
  let result = [maxIndex - minIndex + 1];
  for (let p = minIndex; p <= maxIndex; p += 1) {
    result[p - minIndex] = a[p];
  }
  return result.length;
}