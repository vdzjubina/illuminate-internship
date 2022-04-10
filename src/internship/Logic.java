package internship;

public class Logic {

    static String[] smartPeople(int length) {
        final String[] arr = {"Smart", "People"};
        String[] outputList = new String[length + 1];
        for(int i = 1; i <= length; i++) {
            if(i % 15 != 0 ^ i % 5 != 0 ^ i % 3 != 0) {
                outputList[i] = "...";
            } else if (i % 15 == 0) {
                outputList[i] = String.join(" ", arr);
            } else if (i % 5 == 0) {
                outputList[i] = arr[1];
            } else {
                outputList[i] = arr[0];
            }
        }
        return outputList;
    }
}
