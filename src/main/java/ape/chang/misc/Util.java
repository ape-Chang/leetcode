package ape.chang.misc;

public class Util {
	
	public static<T> String join(T[] array) {
		return join(array, ", ");
	}
	
	public static<T> String join(T[] array, String separator) {
		return join(array, 0, array.length, separator);
	}
	
	public static<T> String join(T[] array, int from, int to, String separator) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (to > from) {
			sb.append(array[from]);
			for (int i = from+1; i < to; ++i) {
				sb.append(separator).append(array[i]);
			}
		}
		return sb.append("]").toString();
	}

}
