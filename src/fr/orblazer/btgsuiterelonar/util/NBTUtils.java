package fr.orblazer.btgsuiterelonar.util;

import java.util.Map;

public final class NBTUtils {
	public static String getTypeName(Class<? extends Tag> clazz) {
		if (clazz.equals(ByteArrayTag.class))
			return "TAG_Byte_Array";
		if (clazz.equals(ByteTag.class))
			return "TAG_Byte";
		if (clazz.equals(CompoundTag.class))
			return "TAG_Compound";
		if (clazz.equals(DoubleTag.class))
			return "TAG_Double";
		if (clazz.equals(EndTag.class))
			return "TAG_End";
		if (clazz.equals(FloatTag.class))
			return "TAG_Float";
		if (clazz.equals(IntTag.class))
			return "TAG_Int";
		if (clazz.equals(ListTag.class))
			return "TAG_List";
		if (clazz.equals(LongTag.class))
			return "TAG_Long";
		if (clazz.equals(ShortTag.class))
			return "TAG_Short";
		if (clazz.equals(StringTag.class))
			return "TAG_String";
		if (clazz.equals(IntArrayTag.class))
			return "TAG_Int_Array";
		
		throw new IllegalArgumentException("Invalid tag classs (" + clazz.getName() + ").");
	}

	public static int getTypeCode(Class<? extends Tag> clazz) {
		if (clazz.equals(ByteArrayTag.class))
			return 7;
		if (clazz.equals(ByteTag.class))
			return 1;
		if (clazz.equals(CompoundTag.class))
			return 10;
		if (clazz.equals(DoubleTag.class))
			return 6;
		if (clazz.equals(EndTag.class))
			return 0;
		if (clazz.equals(FloatTag.class))
			return 5;
		if (clazz.equals(IntTag.class))
			return 3;
		if (clazz.equals(ListTag.class))
			return 9;
		if (clazz.equals(LongTag.class))
			return 4;
		if (clazz.equals(ShortTag.class))
			return 2;
		if (clazz.equals(StringTag.class))
			return 8;
		if (clazz.equals(IntArrayTag.class))
			return 11;

		throw new IllegalArgumentException("Invalid tag classs (" + clazz.getName() + ").");
	}

	public static Class<? extends Tag> getTypeClass(int type) {
		switch (type) {
			case 0:
				return EndTag.class;
			case 1:
				return ByteTag.class;
			case 2:
				return ShortTag.class;
			case 3:
				return IntTag.class;
			case 4:
				return LongTag.class;
			case 5:
				return FloatTag.class;
			case 6:
				return DoubleTag.class;
			case 7:
				return ByteArrayTag.class;
			case 8:
				return StringTag.class;
			case 9:
				return ListTag.class;
			case 10:
				return CompoundTag.class;
			case 11:
				return IntArrayTag.class;
		}
		throw new IllegalArgumentException("Invalid tag type : " + type + ".");
	}

	public static <T extends Tag> T getChildTag(Map<String, Tag> items, String key, Class<T> expected)
				throws Exception {
		if (!items.containsKey(key))
			throw new Exception("Missing a \"" + key + "\" tag");
		
		Tag tag = (Tag)items.get(key);
		if (!expected.isInstance(tag))
			throw new Exception(key + " tag is not of tag type " + expected.getName());

		return (T)expected.cast(tag);
	}
}