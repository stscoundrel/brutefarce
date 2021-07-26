# Brutefarce

Bruteforce passwords in farcical way.

Brutefarce is possibly the least efficient bruteforcing algorithm for cracking passwords. Instead of using a dictionary of likely passwords, it will use randomly generated input each time.

### FAQ
**Does it work?**
Yes, but your mileage will vary. If password is simple, it has decent chance of cracking it rapidly. It password is decently complex, or simply long, it will probably take _long_.

**Doesn't randomness mean it might try same incorrect password many times?**
Absolutely. Every guess is independent, and does not take the previous ones into account whatsoever.

**Can you benchmark it against other algorithms?**
While you can, results would (probably) be different each time. Unlike other algorithms, it actually might get even the strongest password on the first try. But then again, it might never guess even three letter password like "aaa"

**What is the ballpark figure for Brutefarces speed?**
Depends on password, and implementation you're using. For example, the C implementation routinely cracks passwords like "aaa" (min 3, max 10) in less than a second. If you use a more hardcore, complex password like "hunter2", it might take hundreds of millions of guesses.

### To run

Brutefarce accepts three arguments: the password to crack, minimum length, and maximum length of password. For example:

C implementation:
- `yarn run:c hunter2 6 12`