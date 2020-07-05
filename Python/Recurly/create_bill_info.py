import recurly

recurly.SUBDOMAIN = 'tier3fj1'
recurly.API_KEY = 'e9922993342845dbbc583c145b2ab811'

try:
	account = recurly.Account.get('ms~fratella.idea')
	#accountCode = getattr(account, 'account_code')

	billing =account.billing_info

	billing_info = account.billing_info
	billing_info.first_name = 'Verena'
	billing_info.last_name = 'Example'
	billing_info.number = '4111-1111-1111-1111'
	billing_info.verification_value = '123'
	billing_info.month = 11
	billing_info.year = 2015
	account.update_billing_info(billing_info)

	print "Account code: %s \n" % account.account_code
	#print curr

except recurly.errors.NotFoundError:

	print  "Account not found"