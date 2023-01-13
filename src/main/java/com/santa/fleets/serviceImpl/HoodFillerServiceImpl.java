package com.santa.fleets.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santa.fleets.exception.InternalServerError;
import com.santa.fleets.exception.NoDataFoundExceptionHandler;
import com.santa.fleets.exception.RequestValidationException;
import com.santa.fleets.pojo.RequestBodyParam;
import com.santa.fleets.pojo.ResponsePayload;
import com.santa.fleets.service.HoodFillerService;

@Service
public class HoodFillerServiceImpl implements HoodFillerService {

	@Override
	public ResponseEntity<ResponsePayload> hoodFiller(RequestBodyParam requestParam) {

		try {
			ArrayList<ArrayList<Integer>> possibleCombinations = combinationSum(requestParam.getPresent_weights(),
					requestParam.getHood_capacity());
			if (!possibleCombinations.isEmpty()) {

				// It will return list with min size
				List<Integer> minList = possibleCombinations.stream().min(Comparator.comparingInt(List::size)).get();
				ResponsePayload payload = new ResponsePayload(minList);
				return ResponseEntity.ok(payload);
			} else {
				// It will throw 204 if no combination exists
				throw new NoDataFoundExceptionHandler();
			}

		} catch (NoDataFoundExceptionHandler e) {
			throw new NoDataFoundExceptionHandler();
		} catch (RequestValidationException e) {
			throw new RequestValidationException();
		} catch (Exception e) {
			throw new InternalServerError();
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> presentWeights, Integer hoodCapacity) {

		// It will throw 400 if any body param is missing
		if (presentWeights.isEmpty() || null == hoodCapacity) {
			throw new RequestValidationException();
		}

		ArrayList<ArrayList<Integer>> possibleCombination = new ArrayList<>();
		ArrayList<Integer> possibleSubArr = new ArrayList<>();

		// To remove duplicate and sort it in reverse order
		Set<Integer> set = new HashSet<>(presentWeights);
		presentWeights.clear();
		presentWeights.addAll(set);
		Collections.sort(presentWeights, Collections.reverseOrder());

		findNumbers(possibleCombination, presentWeights, hoodCapacity, 0, possibleSubArr);
		return possibleCombination;
	}

	public void findNumbers(ArrayList<ArrayList<Integer>> possibleCombination, List<Integer> presentWeights,
			int hoodCapacity, int index, ArrayList<Integer> possibleSubArr) {

		if (hoodCapacity == 0) {

			// It will add copy of list to possibleCombination

			possibleCombination.add(new ArrayList<>(possibleSubArr));
			return;
		}

		for (int i = index; i < presentWeights.size(); i++) {

			// It will check hoodCapacity remain positive

			if ((hoodCapacity - presentWeights.get(i)) >= 0) {

				// It will add element which can contribute to hoodCapacity

				possibleSubArr.add(presentWeights.get(i));

				findNumbers(possibleCombination, presentWeights, hoodCapacity - presentWeights.get(i), i,
						possibleSubArr);

				possibleSubArr.remove(presentWeights.get(i));
			}
		}
	}
}
