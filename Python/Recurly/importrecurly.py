import recurly

recurly.SUBDOMAIN = 'tier3fj1'
recurly.API_KEY = 'e9922993342845dbbc583c145b2ab811'

#try:
    #account = recurly.Account.get('1')
    #billing_info = account.billing_info
    #print "Account code: %s" % account.account_code
    #lastnums = getattr(billing_info, 'first_six')

   # print lastnums

transaction = Transaction.get('50477b8d6164549b3f13424e0380ed23')
#print trans.lastnums

#except NotFoundError:
    #print "Account not found. \n"