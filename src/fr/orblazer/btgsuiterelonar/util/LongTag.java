<<<<<<< HEAD
package fr.orblazer.btgsuiterelonar.util;

public final class LongTag extends Tag {
	private final long value;

	public LongTag(String name, long value) {
		super(name);
		this.value = value;
	}

	public Long getValue(){
		return Long.valueOf(this.value);
	}

	public String toString() {
		String name = getName();
		String append = "";
		if ((name != null) && (!name.equals(""))) {
			append = "(\"" + getName() + "\")";
		}
		return "TAG_Long" + append + ": " + this.value;
	}
}
=======
/*    */ package com.sk89q.jnbt;
/*    */ 
/*    */ public final class LongTag extends Tag
/*    */ {
/*    */   private final long value;
/*    */ 
/*    */   public LongTag(String name, long value)
/*    */   {
/* 60 */     super(name);
/* 61 */     this.value = value;
/*    */   }
/*    */ sdsd
/*    */   public Long getValue()
/*    */   {
/* 66 */     return Long.valueOf(this.value);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 71 */     String name = getName();
/* 72 */     String append = "";
/* 73 */     if ((name != null) && (!name.equals(""))) {
/* 74 */       append = "(\"" + getName() + "\")";
/*    */     }
/* 76 */     return "TAG_Long" + append + ": " + this.value;
/*    */   }
/*    */ }

/* Location:           C:\Users\orblazer\Desktop\Mes documents\Minecraft\serveur\Azael PvP\plugins\WorldEdit.jar
 * Qualified Name:     com.sk89q.jnbt.LongTag
 * JD-Core Version:    0.6.2
 */
>>>>>>> 08572ffdd14bf910a2eb080818b402f84b4e6058
