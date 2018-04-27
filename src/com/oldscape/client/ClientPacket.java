package com.oldscape.client;

public class ClientPacket implements class179 {

	public static final ClientPacket field2400;

	public static final ClientPacket field2384;

	public static final ClientPacket field2459;

	public static final ClientPacket field2386;

	public static final ClientPacket field2387;

	public static final ClientPacket field2433;

	public static final ClientPacket field2416;

	public static final ClientPacket field2390;

	public static final ClientPacket field2391;

	public static final ClientPacket field2392;

	public static final ClientPacket field2393;

	public static final ClientPacket field2453;

	public static final ClientPacket field2395;

	public static final ClientPacket field2396;

	public static final ClientPacket field2478;

	public static final ClientPacket field2456;

	public static final ClientPacket field2399;

	public static final ClientPacket field2468;

	public static final ClientPacket field2422;

	public static final ClientPacket field2402;

	public static final ClientPacket field2403;

	public static final ClientPacket field2472;

	public static final ClientPacket field2405;

	public static final ClientPacket field2441;

	public static final ClientPacket field2482;

	public static final ClientPacket field2408;

	public static final ClientPacket field2413;

	public static final ClientPacket field2464;

	public static final ClientPacket field2411;

	public static final ClientPacket field2412;

	public static final ClientPacket field2419;

	public static final ClientPacket field2414;

	public static final ClientPacket field2415;

	public static final ClientPacket field2430;

	public static final ClientPacket field2406;

	public static final ClientPacket field2418;

	public static final ClientPacket field2461;

	public static final ClientPacket field2420;

	public static final ClientPacket field2421;

	public static final ClientPacket field2398;

	public static final ClientPacket field2423;

	public static final ClientPacket field2445;

	public static final ClientPacket field2425;

	public static final ClientPacket field2426;

	public static final ClientPacket field2427;

	public static final ClientPacket field2388;

	public static final ClientPacket field2417;

	public static final ClientPacket field2407;

	public static final ClientPacket field2431;

	public static final ClientPacket field2410;

	public static final ClientPacket field2397;

	public static final ClientPacket field2434;

	public static final ClientPacket field2435;

	public static final ClientPacket field2455;

	public static final ClientPacket field2437;

	public static final ClientPacket field2438;

	public static final ClientPacket field2439;

	public static final ClientPacket field2404;

	public static final ClientPacket field2394;

	public static final ClientPacket field2442;

	public static final ClientPacket field2443;

	public static final ClientPacket field2444;

	public static final ClientPacket field2473;

	public static final ClientPacket field2446;

	public static final ClientPacket field2447;

	public static final ClientPacket field2448;

	public static final ClientPacket field2449;

	public static final ClientPacket field2450;

	public static final ClientPacket field2451;

	public static final ClientPacket field2428;

	public static final ClientPacket field2440;

	public static final ClientPacket field2454;

	public static final ClientPacket field2401;

	public static final ClientPacket field2409;

	public static final ClientPacket field2457;

	public static final ClientPacket field2389;

	public static final ClientPacket field2452;

	public static final ClientPacket field2460;

	public static final ClientPacket field2480;

	public static final ClientPacket field2462;

	public static final ClientPacket field2463;

	public static final ClientPacket field2458;

	public static final ClientPacket field2465;

	public static final ClientPacket field2466;

	public static final ClientPacket field2467;

	public static final ClientPacket field2383;

	public static final ClientPacket field2469;

	public static final ClientPacket field2470;

	public static final ClientPacket field2471;

	public static final ClientPacket field2424;

	public static final ClientPacket field2436;

	public static final ClientPacket field2474;

	public static final ClientPacket field2475;

	public static final ClientPacket field2476;

	public static final ClientPacket field2385;

	public static final ClientPacket field2429;

	public static final ClientPacket field2479;

	public static final ClientPacket field2477;

	final int packetId;

	final int packetLength;

	static {
		field2400 = new ClientPacket(0, 16);
		field2384 = new ClientPacket(1, -2);
		field2459 = new ClientPacket(2, -1);
		field2386 = new ClientPacket(3, 3);
		field2387 = new ClientPacket(4, 3);
		field2433 = new ClientPacket(5, 4);
		field2416 = new ClientPacket(6, 7);
		field2390 = new ClientPacket(7, -2);
		field2391 = new ClientPacket(8, 3);
		field2392 = new ClientPacket(9, -1);
		field2393 = new ClientPacket(10, 15);
		field2453 = new ClientPacket(11, 7);
		field2395 = new ClientPacket(12, -1);
		field2396 = new ClientPacket(13, -1);
		field2478 = new ClientPacket(14, 8);
		field2456 = new ClientPacket(15, 14);
		field2399 = new ClientPacket(16, 7);
		field2468 = new ClientPacket(17, 8);
		field2422 = new ClientPacket(18, 8);
		field2402 = new ClientPacket(19, 4);
		field2403 = new ClientPacket(20, 8);
		field2472 = new ClientPacket(21, 3);
		field2405 = new ClientPacket(22, 6);
		field2441 = new ClientPacket(23, 11);
		field2482 = new ClientPacket(24, 0);
		field2408 = new ClientPacket(25, 1);
		field2413 = new ClientPacket(26, -1);
		field2464 = new ClientPacket(27, 0);
		field2411 = new ClientPacket(28, 10);
		field2412 = new ClientPacket(29, 2);
		field2419 = new ClientPacket(30, 15);
		field2414 = new ClientPacket(31, -1);
		field2415 = new ClientPacket(32, -1);
		field2430 = new ClientPacket(33, 8);
		field2406 = new ClientPacket(34, 9);
		field2418 = new ClientPacket(35, 8);
		field2461 = new ClientPacket(36, 13);
		field2420 = new ClientPacket(37, 3);
		field2421 = new ClientPacket(38, 8);
		field2398 = new ClientPacket(39, -1);
		field2423 = new ClientPacket(40, 9);
		field2445 = new ClientPacket(41, 8);
		field2425 = new ClientPacket(42, 3);
		field2426 = new ClientPacket(43, 8);
		field2427 = new ClientPacket(44, 11);
		field2388 = new ClientPacket(45, 13);
		field2417 = new ClientPacket(46, 8);
		field2407 = new ClientPacket(47, 3);
		field2431 = new ClientPacket(48, 3);
		field2410 = new ClientPacket(49, 4);
		field2397 = new ClientPacket(50, -1);
		field2434 = new ClientPacket(51, -1);
		field2435 = new ClientPacket(52, 13);
		field2455 = new ClientPacket(53, 2);
		field2437 = new ClientPacket(54, 7);
		field2438 = new ClientPacket(55, 2);
		field2439 = new ClientPacket(56, 8);
		field2404 = new ClientPacket(57, 5);
		field2394 = new ClientPacket(58, 7);
		field2442 = new ClientPacket(59, 9);
		field2443 = new ClientPacket(60, 7);
		field2444 = new ClientPacket(61, 16);
		field2473 = new ClientPacket(62, 3);
		field2446 = new ClientPacket(63, 8);
		field2447 = new ClientPacket(64, 6);
		field2448 = new ClientPacket(65, 8);
		field2449 = new ClientPacket(66, 8);
		field2450 = new ClientPacket(67, -1);
		field2451 = new ClientPacket(68, 7);
		field2428 = new ClientPacket(69, 0);
		field2440 = new ClientPacket(70, 8);
		field2454 = new ClientPacket(71, 3);
		field2401 = new ClientPacket(72, 3);
		field2409 = new ClientPacket(73, 4);
		field2457 = new ClientPacket(74, 9);
		field2389 = new ClientPacket(75, 2);
		field2452 = new ClientPacket(76, 0);
		field2460 = new ClientPacket(77, 4);
		field2480 = new ClientPacket(78, -1);
		field2462 = new ClientPacket(79, -1);
		field2463 = new ClientPacket(80, 8);
		field2458 = new ClientPacket(81, 3);
		field2465 = new ClientPacket(82, 16);
		field2466 = new ClientPacket(83, 7);
		field2467 = new ClientPacket(84, 7);
		field2383 = new ClientPacket(85, 8);
		field2469 = new ClientPacket(86, 7);
		field2470 = new ClientPacket(87, -1);
		field2471 = new ClientPacket(88, -1);
		field2424 = new ClientPacket(89, 3);
		field2436 = new ClientPacket(90, 8);
		field2474 = new ClientPacket(91, 3);
		field2475 = new ClientPacket(92, -1);
		field2476 = new ClientPacket(93, -1);
		field2385 = new ClientPacket(94, -2);
		field2429 = new ClientPacket(95, 8);
		field2479 = new ClientPacket(96, 8);
		field2477 = new ClientPacket(97, 0);
	}

	ClientPacket(int var1, int var2) {
		this.packetId = var1;
		this.packetLength = var2;
	}

	static int method3434(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
		} else {
			var3 = var2 ? class81.field1285 : Signlink.field2218;
		}

		if (var0 == 1927) {
			if (class81.field1288 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResizeListener == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.objs = var3.onResizeListener;
				var4.field806 = class81.field1288 + 1;
				Client.field1066.addFront(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}
}
