export const isMobile = ():boolean => {
    let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec |wOSBrowser|BrowserNG|WebOS|Symbian| Windows phone)/i)
    if(null == flag){
        return false;
    }else{
        return true;
    }
}