package com.oldscape.client;

public class Widget extends Node {

	static IndexDataBase field2815;

	static NodeCache field2817;

	static NodeCache Widget_cachedModels;

	static NodeCache Widget_cachedFonts;

	static NodeCache field2819;

	public static boolean field2820;

	public boolean hasScript;

	public int id;

	public int index;

	public int type;

	public int field2932;

	public int contentType;

	public int dynamicX;

	public int dynamicY;

	public int dynamicWidth;

	public int buttonType;

	public int originalX;

	public int originalY;

	public int originalWidth;

	public int originalHeight;

	public int relativeX;

	public int relativeY;

	public int width;

	public int height;

	public int field2839;

	public int field2840;

	public int parentId;

	public boolean isHidden;

	public int scrollX;

	public int scrollY;

	public int scrollWidth;

	public int scrollHeight;

	public int textColor;

	public int field2841;

	public int field2849;

	public int field2908;

	public boolean filled;

	public class329 field2909;

	public int opacity;

	public int field2854;

	public int lineWidth;

	public boolean field2903;

	public int spriteId;

	public int field2858;

	public int textureId;

	public boolean spriteTiling;

	public int borderThickness;

	public int sprite2;

	public boolean flippedVertically;

	public boolean flippedHorizontally;

	public int modelType;

	public int modelId;

	int field2867;

	int field2868;

	public int field2869;

	public int field2855;

	public int offsetX2d;

	public int offsetY2d;

	public int rotationX;

	public int rotationZ;

	public int rotationY;

	public int modelZoom;

	public int field2880;

	public int field2904;

	public boolean field2879;

	public int field2853;

	public int fontId;

	public String text;

	public String string1;

	public int field2884;

	public int field2885;

	public int field2833;

	public boolean textShadowed;

	public int paddingX;

	public int paddingY;

	public int[] xSprites;

	public int[] field2915;

	public int[] field2892;

	public String[] configActions;

	public int clickMask;

	public String opBase;

	public String[] actions;

	public Widget dragParent;

	public int dragDeadZone;

	public int dragDeadTime;

	public boolean dragRenderBehavior;

	public String targetVerb;

	public boolean hasListener;

	public Object[] onLoadListener;

	public Object[] onClickListener;

	public Object[] onClickRepeatListener;

	public Object[] onReleaseListener;

	public Object[] onHoldListener;

	public Object[] onMouseOverListener;

	public Object[] onMouseRepeatListener;

	public Object[] onMouseLeaveListener;

	public Object[] onDragListener;

	public Object[] onDragCompleteListener;

	public Object[] onTargetEnterListener;

	public Object[] onTargetLeaveListener;

	public Object[] onVarTransmitListener;

	public int[] varTransmitTriggers;

	public Object[] onInvTransmitListener;

	public int[] invTransmitTriggers;

	public Object[] onStatTransmitListener;

	public int[] statTransmitTriggers;

	public Object[] onTimerListener;

	public Object[] onOpListener;

	public Object[] onScrollWheelListener;

	public Object[] onChatTransmitListener;

	public Object[] onKeyListener;

	public Object[] onFriendTransmitListener;

	public Object[] onClanTransmitListener;

	public Object[] onMiscTransmitListener;

	public Object[] onDialogAbortListener;

	public Object[] onSubChangeListener;

	public Object[] onResizeListener;

	public Object[] onStockTransmitListener;

	public Object[] onCamFinishedListener;

	public int[][] dynamicValues;

	public int[] tableActions;

	public int[] field2936;

	public int field2937;

	public String spellName;

	public String tooltip;

	public int[] itemIds;

	public int[] itemQuantities;

	public int itemId;

	public int itemQuantity;

	public int field2935;

	public int field2945;

	public Widget[] children;

	public boolean field2835;

	public boolean field2948;

	public int field2949;

	public int field2950;

	public int field2951;

	public int field2856;

	public int boundsIndex;

	public int loopCycle;

	public boolean noClickThrough;

	public boolean noScrollThrough;

	static {
		field2817 = new NodeCache(200);
		Widget_cachedModels = new NodeCache(50);
		Widget_cachedFonts = new NodeCache(20);
		field2819 = new NodeCache(8);
		field2820 = false;
	}

	public Widget() {
		this.hasScript = false;
		this.id = -1;
		this.index = -1;
		this.field2932 = 0;
		this.contentType = 0;
		this.dynamicX = 0;
		this.dynamicY = 0;
		this.dynamicWidth = 0;
		this.buttonType = 0;
		this.originalX = 0;
		this.originalY = 0;
		this.originalWidth = 0;
		this.originalHeight = 0;
		this.relativeX = 0;
		this.relativeY = 0;
		this.width = 0;
		this.height = 0;
		this.field2839 = 1;
		this.field2840 = 1;
		this.parentId = -1;
		this.isHidden = false;
		this.scrollX = 0;
		this.scrollY = 0;
		this.scrollWidth = 0;
		this.scrollHeight = 0;
		this.textColor = 0;
		this.field2841 = 0;
		this.field2849 = 0;
		this.field2908 = 0;
		this.filled = false;
		this.field2909 = class329.field3965;
		this.opacity = 0;
		this.field2854 = 0;
		this.lineWidth = 1;
		this.field2903 = false;
		this.spriteId = -1;
		this.field2858 = -1;
		this.textureId = 0;
		this.spriteTiling = false;
		this.borderThickness = 0;
		this.sprite2 = 0;
		this.modelType = 1;
		this.modelId = -1;
		this.field2867 = 1;
		this.field2868 = -1;
		this.field2869 = -1;
		this.field2855 = -1;
		this.offsetX2d = 0;
		this.offsetY2d = 0;
		this.rotationX = 0;
		this.rotationZ = 0;
		this.rotationY = 0;
		this.modelZoom = 100;
		this.field2880 = 0;
		this.field2904 = 0;
		this.field2879 = false;
		this.field2853 = 2;
		this.fontId = -1;
		this.text = "";
		this.string1 = "";
		this.field2884 = 0;
		this.field2885 = 0;
		this.field2833 = 0;
		this.textShadowed = false;
		this.paddingX = 0;
		this.paddingY = 0;
		this.clickMask = 0;
		this.opBase = "";
		this.dragParent = null;
		this.dragDeadZone = 0;
		this.dragDeadTime = 0;
		this.dragRenderBehavior = false;
		this.targetVerb = "";
		this.hasListener = false;
		this.field2937 = -1;
		this.spellName = "";
		this.tooltip = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.field2935 = 0;
		this.field2945 = 0;
		this.field2835 = false;
		this.field2948 = false;
		this.field2949 = -1;
		this.field2950 = 0;
		this.field2951 = 0;
		this.field2856 = 0;
		this.boundsIndex = -1;
		this.loopCycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
	}

	void decode(Buffer var1) {
		this.hasScript = false;
		this.type = var1.readUnsignedByte();
		this.field2932 = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.originalX = var1.readShort();
		this.originalY = var1.readShort();
		this.originalWidth = var1.readUnsignedShort();
		this.originalHeight = var1.readUnsignedShort();
		this.opacity = var1.readUnsignedByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.field2937 = var1.readUnsignedShort();
		if (this.field2937 == 65535) {
			this.field2937 = -1;
		}

		int var2 = var1.readUnsignedByte();
		int var3;
		if (var2 > 0) {
			this.tableActions = new int[var2];
			this.field2936 = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.tableActions[var3] = var1.readUnsignedByte();
				this.field2936[var3] = var1.readUnsignedShort();
			}
		}

		var3 = var1.readUnsignedByte();
		int var4;
		int var5;
		int var6;
		if (var3 > 0) {
			this.dynamicValues = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4) {
				var5 = var1.readUnsignedShort();
				this.dynamicValues[var4] = new int[var5];

				for (var6 = 0; var6 < var5; ++var6) {
					this.dynamicValues[var4][var6] = var1.readUnsignedShort();
					if (this.dynamicValues[var4][var6] == 65535) {
						this.dynamicValues[var4][var6] = -1;
					}
				}
			}
		}

		if (this.type == 0) {
			this.scrollHeight = var1.readUnsignedShort();
			this.isHidden = var1.readUnsignedByte() == 1;
		}

		if (this.type == 1) {
			var1.readUnsignedShort();
			var1.readUnsignedByte();
		}

		if (this.type == 2) {
			this.itemIds = new int[this.originalHeight * this.originalWidth];
			this.itemQuantities = new int[this.originalHeight * this.originalWidth];
			var4 = var1.readUnsignedByte();
			if (var4 == 1) {
				this.clickMask |= 268435456;
			}

			var5 = var1.readUnsignedByte();
			if (var5 == 1) {
				this.clickMask |= 1073741824;
			}

			var6 = var1.readUnsignedByte();
			if (var6 == 1) {
				this.clickMask |= Integer.MIN_VALUE;
			}

			int var7 = var1.readUnsignedByte();
			if (var7 == 1) {
				this.clickMask |= 536870912;
			}

			this.paddingX = var1.readUnsignedByte();
			this.paddingY = var1.readUnsignedByte();
			this.xSprites = new int[20];
			this.field2915 = new int[20];
			this.field2892 = new int[20];

			int var8;
			for (var8 = 0; var8 < 20; ++var8) {
				int var9 = var1.readUnsignedByte();
				if (var9 == 1) {
					this.xSprites[var8] = var1.readShort();
					this.field2915[var8] = var1.readShort();
					this.field2892[var8] = var1.readInt();
				} else {
					this.field2892[var8] = -1;
				}
			}

			this.configActions = new String[5];

			for (var8 = 0; var8 < 5; ++var8) {
				String var11 = var1.readString();
				if (var11.length() > 0) {
					this.configActions[var8] = var11;
					this.clickMask |= 1 << var8 + 23;
				}
			}
		}

		if (this.type == 3) {
			this.filled = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			this.field2885 = var1.readUnsignedByte();
			this.field2833 = var1.readUnsignedByte();
			this.field2884 = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4) {
			this.text = var1.readString();
			this.string1 = var1.readString();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.textColor = var1.readInt();
		}

		if (this.type == 3 || this.type == 4) {
			this.field2841 = var1.readInt();
			this.field2849 = var1.readInt();
			this.field2908 = var1.readInt();
		}

		if (this.type == 5) {
			this.spriteId = var1.readInt();
			this.field2858 = var1.readInt();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.field2867 = 1;
			this.field2868 = var1.readUnsignedShort();
			if (this.field2868 == 65535) {
				this.field2868 = -1;
			}

			this.field2869 = var1.readUnsignedShort();
			if (this.field2869 == 65535) {
				this.field2869 = -1;
			}

			this.field2855 = var1.readUnsignedShort();
			if (this.field2855 == 65535) {
				this.field2855 = -1;
			}

			this.modelZoom = var1.readUnsignedShort();
			this.rotationX = var1.readUnsignedShort();
			this.rotationZ = var1.readUnsignedShort();
		}

		if (this.type == 7) {
			this.itemIds = new int[this.originalHeight * this.originalWidth];
			this.itemQuantities = new int[this.originalWidth * this.originalHeight];
			this.field2885 = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
			this.textColor = var1.readInt();
			this.paddingX = var1.readShort();
			this.paddingY = var1.readShort();
			var4 = var1.readUnsignedByte();
			if (var4 == 1) {
				this.clickMask |= 1073741824;
			}

			this.configActions = new String[5];

			for (var5 = 0; var5 < 5; ++var5) {
				String var10 = var1.readString();
				if (var10.length() > 0) {
					this.configActions[var5] = var10;
					this.clickMask |= 1 << var5 + 23;
				}
			}
		}

		if (this.type == 8) {
			this.text = var1.readString();
		}

		if (this.field2932 == 2 || this.type == 2) {
			this.targetVerb = var1.readString();
			this.spellName = var1.readString();
			var4 = var1.readUnsignedShort() & 63;
			this.clickMask |= var4 << 11;
		}

		if (this.field2932 == 1 || this.field2932 == 4 || this.field2932 == 5 || this.field2932 == 6) {
			this.tooltip = var1.readString();
			if (this.tooltip.length() == 0) {
				if (this.field2932 == 1) {
					this.tooltip = "Ok";
				}

				if (this.field2932 == 4) {
					this.tooltip = "Select";
				}

				if (this.field2932 == 5) {
					this.tooltip = "Select";
				}

				if (this.field2932 == 6) {
					this.tooltip = "Continue";
				}
			}
		}

		if (this.field2932 == 1 || this.field2932 == 4 || this.field2932 == 5) {
			this.clickMask |= 4194304;
		}

		if (this.field2932 == 6) {
			this.clickMask |= 1;
		}

	}

	void decodeActive(Buffer var1) {
		var1.readUnsignedByte();
		this.hasScript = true;
		this.type = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.originalX = var1.readShort();
		this.originalY = var1.readShort();
		this.originalWidth = var1.readUnsignedShort();
		if (this.type == 9) {
			this.originalHeight = var1.readShort();
		} else {
			this.originalHeight = var1.readUnsignedShort();
		}

		this.dynamicWidth = var1.readByte();
		this.buttonType = var1.readByte();
		this.dynamicX = var1.readByte();
		this.dynamicY = var1.readByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.isHidden = var1.readUnsignedByte() == 1;
		if (this.type == 0) {
			this.scrollWidth = var1.readUnsignedShort();
			this.scrollHeight = var1.readUnsignedShort();
			this.noClickThrough = var1.readUnsignedByte() == 1;
		}

		if (this.type == 5) {
			this.spriteId = var1.readInt();
			this.textureId = var1.readUnsignedShort();
			this.spriteTiling = var1.readUnsignedByte() == 1;
			this.opacity = var1.readUnsignedByte();
			this.borderThickness = var1.readUnsignedByte();
			this.sprite2 = var1.readInt();
			this.flippedVertically = var1.readUnsignedByte() == 1;
			this.flippedHorizontally = var1.readUnsignedByte() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.offsetX2d = var1.readShort();
			this.offsetY2d = var1.readShort();
			this.rotationX = var1.readUnsignedShort();
			this.rotationZ = var1.readUnsignedShort();
			this.rotationY = var1.readUnsignedShort();
			this.modelZoom = var1.readUnsignedShort();
			this.field2869 = var1.readUnsignedShort();
			if (this.field2869 == 65535) {
				this.field2869 = -1;
			}

			this.field2879 = var1.readUnsignedByte() == 1;
			var1.readUnsignedShort();
			if (this.dynamicWidth != 0) {
				this.field2880 = var1.readUnsignedShort();
			}

			if (this.buttonType != 0) {
				var1.readUnsignedShort();
			}
		}

		if (this.type == 4) {
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.text = var1.readString();
			this.field2884 = var1.readUnsignedByte();
			this.field2885 = var1.readUnsignedByte();
			this.field2833 = var1.readUnsignedByte();
			this.textShadowed = var1.readUnsignedByte() == 1;
			this.textColor = var1.readInt();
		}

		if (this.type == 3) {
			this.textColor = var1.readInt();
			this.filled = var1.readUnsignedByte() == 1;
			this.opacity = var1.readUnsignedByte();
		}

		if (this.type == 9) {
			this.lineWidth = var1.readUnsignedByte();
			this.textColor = var1.readInt();
			this.field2903 = var1.readUnsignedByte() == 1;
		}

		this.clickMask = var1.read24BitInt();
		this.opBase = var1.readString();
		int var2 = var1.readUnsignedByte();
		if (var2 > 0) {
			this.actions = new String[var2];

			for (int var3 = 0; var3 < var2; ++var3) {
				this.actions[var3] = var1.readString();
			}
		}

		this.dragDeadZone = var1.readUnsignedByte();
		this.dragDeadTime = var1.readUnsignedByte();
		this.dragRenderBehavior = var1.readUnsignedByte() == 1;
		this.targetVerb = var1.readString();
		this.onLoadListener = this.decodeListener(var1);
		this.onMouseOverListener = this.decodeListener(var1);
		this.onMouseLeaveListener = this.decodeListener(var1);
		this.onTargetLeaveListener = this.decodeListener(var1);
		this.onTargetEnterListener = this.decodeListener(var1);
		this.onVarTransmitListener = this.decodeListener(var1);
		this.onInvTransmitListener = this.decodeListener(var1);
		this.onStatTransmitListener = this.decodeListener(var1);
		this.onTimerListener = this.decodeListener(var1);
		this.onOpListener = this.decodeListener(var1);
		this.onMouseRepeatListener = this.decodeListener(var1);
		this.onClickListener = this.decodeListener(var1);
		this.onClickRepeatListener = this.decodeListener(var1);
		this.onReleaseListener = this.decodeListener(var1);
		this.onHoldListener = this.decodeListener(var1);
		this.onDragListener = this.decodeListener(var1);
		this.onDragCompleteListener = this.decodeListener(var1);
		this.onScrollWheelListener = this.decodeListener(var1);
		this.varTransmitTriggers = this.decodeTransmitList(var1);
		this.invTransmitTriggers = this.decodeTransmitList(var1);
		this.statTransmitTriggers = this.decodeTransmitList(var1);
	}

	Object[] decodeListener(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			Object[] var3 = new Object[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				int var5 = var1.readUnsignedByte();
				if (var5 == 0) {
					var3[var4] = new Integer(var1.readInt());
				} else if (var5 == 1) {
					var3[var4] = var1.readString();
				}
			}

			this.hasListener = true;
			return var3;
		}
	}

	int[] decodeTransmitList(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			int[] var3 = new int[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				var3[var4] = var1.readInt();
			}

			return var3;
		}
	}

	public void method4461(int var1, int var2) {
		int var3 = this.itemIds[var2];
		this.itemIds[var2] = this.itemIds[var1];
		this.itemIds[var1] = var3;
		var3 = this.itemQuantities[var2];
		this.itemQuantities[var2] = this.itemQuantities[var1];
		this.itemQuantities[var1] = var3;
	}

	public SpritePixels method4431(boolean var1) {
		field2820 = false;
		int var2;
		if (var1) {
			var2 = this.field2858;
		} else {
			var2 = this.spriteId;
		}

		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long) this.sprite2 << 40) + ((this.flippedVertically ? 1L : 0L) << 38)
					+ ((long) this.borderThickness << 36) + var2 + ((this.flippedHorizontally ? 1L : 0L) << 39);
			SpritePixels var5 = (SpritePixels) field2817.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				var5 = SoundTaskDataProvider.method817(field2815, var2, 0);
				if (var5 == null) {
					field2820 = true;
					return null;
				} else {
					if (this.flippedVertically) {
						var5.method5853();
					}

					if (this.flippedHorizontally) {
						var5.method5852();
					}

					if (this.borderThickness > 0) {
						var5.method5933(this.borderThickness);
					}

					if (this.borderThickness >= 1) {
						var5.method5854(1);
					}

					if (this.borderThickness >= 2) {
						var5.method5854(16777215);
					}

					if (this.sprite2 != 0) {
						var5.method5855(this.sprite2);
					}

					field2817.put(var5, var3);
					return var5;
				}
			}
		}
	}

	public Font getFont() {
		field2820 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font) Widget_cachedFonts.get(this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FontName.method5488(field2815, DynamicObject.field1471, this.fontId, 0);
				if (var1 != null) {
					Widget_cachedFonts.put(var1, this.fontId);
				} else {
					field2820 = true;
				}

				return var1;
			}
		}
	}

	public SpritePixels method4423(int var1) {
		field2820 = false;
		if (var1 >= 0 && var1 < this.field2892.length) {
			int var2 = this.field2892[var1];
			if (var2 == -1) {
				return null;
			} else {
				SpritePixels var3 = (SpritePixels) field2817.get(var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = SoundTaskDataProvider.method817(field2815, var2, 0);
					if (var3 != null) {
						field2817.put(var3, var2);
					} else {
						field2820 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	public Model getModel(Sequence var1, int var2, boolean var3, PlayerComposition var4) {
		field2820 = false;
		int var5;
		int var6;
		if (var3) {
			var5 = this.field2867;
			var6 = this.field2868;
		} else {
			var5 = this.modelType;
			var6 = this.modelId;
		}

		if (var5 == 0) {
			return null;
		} else if (var5 == 1 && var6 == -1) {
			return null;
		} else {
			Model var7 = (Model) Widget_cachedModels.get(var6 + (var5 << 16));
			if (var7 == null) {
				ModelData var8;
				if (var5 == 1) {
					var8 = ModelData.method2645(Friend.field3864, var6, 0);
					if (var8 == null) {
						field2820 = true;
						return null;
					}

					var7 = var8.light(64, 768, -50, -10, -50);
				}

				if (var5 == 2) {
					var8 = class234.getNpcDefinition(var6).method5148();
					if (var8 == null) {
						field2820 = true;
						return null;
					}

					var7 = var8.light(64, 768, -50, -10, -50);
				}

				if (var5 == 3) {
					if (var4 == null) {
						return null;
					}

					var8 = var4.method4384();
					if (var8 == null) {
						field2820 = true;
						return null;
					}

					var7 = var8.light(64, 768, -50, -10, -50);
				}

				if (var5 == 4) {
					ItemComposition var9 = class47.getItemDefinition(var6);
					var8 = var9.method5089(10);
					if (var8 == null) {
						field2820 = true;
						return null;
					}

					var7 = var8.light(var9.ambient + 64, var9.contrast * 5 + 768, -50, -10, -50);
				}

				Widget_cachedModels.put(var7, var6 + (var5 << 16));
			}

			if (var1 != null) {
				var7 = var1.method5180(var7, var2);
			}

			return var7;
		}
	}

	public class236 method4425(boolean var1) {
		if (this.field2858 == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.field2858 : this.spriteId;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((long) this.sprite2 << 40) + ((long) this.borderThickness << 36) + var2
					+ ((this.flippedVertically ? 1L : 0L) << 38) + ((this.flippedHorizontally ? 1L : 0L) << 39);
			class236 var5 = (class236) field2819.get(var3);
			if (var5 != null) {
				return var5;
			} else {
				SpritePixels var6 = this.method4431(var1);
				if (var6 == null) {
					return null;
				} else {
					SpritePixels var7 = var6.copy();
					int[] var8 = new int[var7.height];
					int[] var9 = new int[var7.height];

					for (int var10 = 0; var10 < var7.height; ++var10) {
						int var11 = 0;
						int var12 = var7.width;

						int var13;
						for (var13 = 0; var13 < var7.width; ++var13) {
							if (var7.pixels[var13 + var10 * var7.width] == 0) {
								var11 = var13;
								break;
							}
						}

						for (var13 = var7.width - 1; var13 >= var11; --var13) {
							if (var7.pixels[var13 + var10 * var7.width] == 0) {
								var12 = var13 + 1;
								break;
							}
						}

						var8[var10] = var11;
						var9[var10] = var12 - var11;
					}

					var5 = new class236(var7.width, var7.height, var9, var8, var2);
					field2819.put(var5, var3);
					return var5;
				}
			}
		}
	}

	public void setAction(int var1, String var2) {
		if (this.actions == null || this.actions.length <= var1) {
			String[] var3 = new String[var1 + 1];
			if (this.actions != null) {
				for (int var4 = 0; var4 < this.actions.length; ++var4) {
					var3[var4] = this.actions[var4];
				}
			}

			this.actions = var3;
		}

		this.actions[var1] = var2;
	}

	static final void method4465() {
		int var0 = ScriptState.field755 * 128 + 64;
		int var1 = class37.field497 * 128 + 64;
		int var2 = class265.getTileHeight(var0, var1, BoundingBox3DDrawMode.plane) - Renderable.field2051;
		if (Player.cameraX < var0) {
			Player.cameraX = (var0 - Player.cameraX) * class255.field3331 / 1000 + Player.cameraX + class28.field416;
			if (Player.cameraX > var0) {
				Player.cameraX = var0;
			}
		}

		if (Player.cameraX > var0) {
			Player.cameraX -= class255.field3331 * (Player.cameraX - var0) / 1000 + class28.field416;
			if (Player.cameraX < var0) {
				Player.cameraX = var0;
			}
		}

		if (GameObject.cameraZ < var2) {
			GameObject.cameraZ = (var2 - GameObject.cameraZ) * class255.field3331 / 1000 + GameObject.cameraZ
					+ class28.field416;
			if (GameObject.cameraZ > var2) {
				GameObject.cameraZ = var2;
			}
		}

		if (GameObject.cameraZ > var2) {
			GameObject.cameraZ -= class255.field3331 * (GameObject.cameraZ - var2) / 1000 + class28.field416;
			if (GameObject.cameraZ < var2) {
				GameObject.cameraZ = var2;
			}
		}

		if (class20.cameraY < var1) {
			class20.cameraY = (var1 - class20.cameraY) * class255.field3331 / 1000 + class20.cameraY + class28.field416;
			if (class20.cameraY > var1) {
				class20.cameraY = var1;
			}
		}

		if (class20.cameraY > var1) {
			class20.cameraY -= class255.field3331 * (class20.cameraY - var1) / 1000 + class28.field416;
			if (class20.cameraY < var1) {
				class20.cameraY = var1;
			}
		}

		var0 = HorizontalAlignment.field3697 * 128 + 64;
		var1 = BoundingBox2D.field248 * 128 + 64;
		var2 = class265.getTileHeight(var0, var1, BoundingBox3DDrawMode.plane) - Signlink.field2217;
		int var3 = var0 - Player.cameraX;
		int var4 = var2 - GameObject.cameraZ;
		int var5 = var1 - class20.cameraY;
		int var6 = (int) Math.sqrt(var5 * var5 + var3 * var3);
		int var7 = (int) (Math.atan2(var4, var6) * 325.949D) & 2047;
		int var8 = (int) (Math.atan2(var3, var5) * -325.949D) & 2047;
		if (var7 < 128) {
			var7 = 128;
		}

		if (var7 > 383) {
			var7 = 383;
		}

		if (GrandExchangeOffer.cameraPitch < var7) {
			GrandExchangeOffer.cameraPitch = (var7 - GrandExchangeOffer.cameraPitch) * ScriptVarType.field230 / 1000
					+ GrandExchangeOffer.cameraPitch + TotalQuantityComparator.field302;
			if (GrandExchangeOffer.cameraPitch > var7) {
				GrandExchangeOffer.cameraPitch = var7;
			}
		}

		if (GrandExchangeOffer.cameraPitch > var7) {
			GrandExchangeOffer.cameraPitch -= ScriptVarType.field230 * (GrandExchangeOffer.cameraPitch - var7) / 1000
					+ TotalQuantityComparator.field302;
			if (GrandExchangeOffer.cameraPitch < var7) {
				GrandExchangeOffer.cameraPitch = var7;
			}
		}

		int var9 = var8 - class28.cameraYaw;
		if (var9 > 1024) {
			var9 -= 2048;
		}

		if (var9 < -1024) {
			var9 += 2048;
		}

		if (var9 > 0) {
			class28.cameraYaw = var9 * ScriptVarType.field230 / 1000 + class28.cameraYaw
					+ TotalQuantityComparator.field302;
			class28.cameraYaw &= 2047;
		}

		if (var9 < 0) {
			class28.cameraYaw -= -var9 * ScriptVarType.field230 / 1000 + TotalQuantityComparator.field302;
			class28.cameraYaw &= 2047;
		}

		int var10 = var8 - class28.cameraYaw;
		if (var10 > 1024) {
			var10 -= 2048;
		}

		if (var10 < -1024) {
			var10 += 2048;
		}

		if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
			class28.cameraYaw = var8;
		}

	}
}
