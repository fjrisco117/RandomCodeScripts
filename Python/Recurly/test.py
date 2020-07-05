import recurly

recurly.SUBDOMAIN = 'tier3fj1'
recurly.API_KEY = 'e9922993342845dbbc583c145b2ab811'

try:
	account = recurly.Account.get('ms~fratella.idea')
	#accountCode = getattr(account, 'account_code')

	billingInfo = account.billing_info
	zip = getattr(billingInfo, 'zip')

	#code = account.account_code
	#billingInfo = getattr(account, 'billing_info')
	#dump(billingInfo)
	
	print "Account code: %s \n" % account.account_code
	print zip

except recurly.errors.NotFoundError:

	print  "Account not found"
