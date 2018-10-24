var arrayTasks = {

	concat: function (arr1, arr2) {
		return arr1.concat(arr2);
	},

	insertAt: function (arr, itemToAdd, index) {
		arr.splice(index, 0, itemToAdd);
		return arr;
	},

	square: function (arr) {
		return arr.map(function (number) {
			return number * number
		})
	},

	sum: function (arr) {
		return arr.reduce(function (total, number) {
			return number + total
		})
	},

	findDuplicates: function(arr) {
		var counts = {};

		var newSolution = arr.filter(function (item) {
		  if (!counts[item]) {
		    counts[item] = 1
		  } else {
		    counts[item] += 1
		    if (counts[item] === 2) return true
		  }
		})
		return newSolution;
	},

	// findDuplicates: function (arr) {
	//       var duplicates = [];
	//           arr.forEach(function(number, index) {
	//               if (arr.indexOf(number, index + 1) > -1) {
	//                   if (duplicates.indexOf(number) === -1) {
	//                       duplicates.push(number);
	//                   }
	//               }
	//           })
	//       return duplicates;
	// }

	removeAndClone: function (arr, valueToRemove) {
		return arr.filter(function (item) {
			return item !== valueToRemove
		})
	},

	findIndexesOf: function (arr, itemToFind) {
		var results = []

		arr.forEach(function (item, index) {
			if (item === itemToFind) results.push(index)
		})

		return results
	},

	sumOfAllEvenNumbersSquared: function (arr) {
		return arr.reduce(function (total, number) {
			if (number % 2 === 0) {
				return total + Math.pow(number, 2)
			}
			return total
		}, 0)
	}


}

module.exports = arrayTasks
